/*
Author: John Grden
email: neoRiley@gmail.com

This sample is a basic recorder.  It saves the stream to the webapps/oflaDemo/streams folder and plays
it back once you click the stop button.
*/

import mx.utils.Delegate;

// create basic netConnection object
var nc:NetConnection = new NetConnection();

// connect to the local Red5 server
nc.connect("rtmp://localhost/oflaDemo");

// create the netStream object and pass the netConnection object in the constructor
var ns:NetStream = new NetStream(nc);

// get references to the camera and mic
var cam:Camera = Camera.get();
var mic:Microphone = Microphone.get();

// setup some simple settings with the cam and mic for quality
setupCameraMic();

// we store the last saved recording so we can play it back when stop is clicked
var lastVideoName:String = "";

// listen for the button clicks
playButton.addEventListener("click", Delegate.create(this, playClick));
stopButton.addEventListener("click", Delegate.create(this, stopClick));

function playClick():Void
{
	// This FLV is recorded to webapps/oflaDemo/streams/ directory
	// attach cam and mic to the NetStream Object
	ns.attachVideo(cam);
	ns.attachAudio(mic);
	
	// attach the cam to the videoContainer on stage so we can see ourselves
	videoContainer.attachVideo(cam);
	
	// create a random number to store a unique name
	lastVideoName = "red5RecordDemo_" + random(getTimer());
	ns.publish(lastVideoName, "record");
	
	// disable the playbutton
	playButton.enabled = false;
	
	// enable the stop button
	stopButton.enabled = true;
}

function stopClick():Void
{
	// close the netStream object
	ns.close();
	
	// clear the videoContainer
	videoContainer.attachVideo(null);
	videoContainer.clear();
	
	// enable the playbutton
	playButton.enabled = true;
	
	// disable the stop button
	stopButton.enabled = false;
	
	// play the recording back
	playLastVideo();
}

function playLastVideo():Void
{
	// attach the netStream object to the video object
	videoContainer.attachVideo(ns);
	
	// play back the recorded stream
	ns.play(lastVideoName);
}

function setupCameraMic():Void
{
	// setup cam
	cam = Camera.get();
	// setting dimensions and framerate
	cam.setMode(320, 240, 30);
	// set to minimum of 70% quality
	cam.setQuality(0,70);
	
	// setup mic
	mic = Microphone.get();
	mic.setRate(44);
}