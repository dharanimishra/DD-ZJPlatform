/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
To use this component please contact sales@dhtmlx.com to obtain license
*/
Scheduler.plugin(function(a){a.xy.map_date_width=188;a.xy.map_description_width=400;a.config.map_resolve_event_location=!0;a.config.map_resolve_user_location=!0;a.config.map_initial_position=new google.maps.LatLng(48.724,8.215);a.config.map_error_position=new google.maps.LatLng(15,15);a.config.map_infowindow_max_width=300;a.config.map_type=google.maps.MapTypeId.ROADMAP;a.config.map_zoom_after_resolve=15;a.locale.labels.marker_geo_success="It seems you are here.";a.locale.labels.marker_geo_fail="Sorry, could not get your current position using geolocation.";
a.templates.marker_date=a.date.date_to_str("%Y-%m-%d %H:%i");a.templates.marker_text=function(g,h,f){return"<div><b>"+f.text+"</b><br/><br/>"+(f.event_location||"")+"<br/><br/>"+a.templates.marker_date(g)+" - "+a.templates.marker_date(h)+"</div>"};a.dblclick_dhx_map_area=function(){!this.config.readonly&&this.config.dblclick_create&&this.addEventNow({start_date:a._date,end_date:a.date.add(a._date,a.config.time_step,"minute")})};a.templates.map_time=function(g,h,f){return f._timed?this.day_date(f.start_date,
f.end_date,f)+" "+this.event_date(g):a.templates.day_date(g)+" &ndash; "+a.templates.day_date(h)};a.templates.map_text=function(a,h,f){return f.text};a.date.map_start=function(a){return a};a.date.add_map=function(a){return new Date(a.valueOf())};a.templates.map_date=function(){return""};a._latLngUpdate=!1;a.attachEvent("onSchedulerReady",function(){function g(b){if(b){var d=a.locale.labels;a._els.dhx_cal_header[0].innerHTML="<div class='dhx_map_line' style='width: "+(a.xy.map_date_width+a.xy.map_description_width+
2)+"px;' ><div class='headline_date' style='width: "+a.xy.map_date_width+"px;'>"+d.date+"</div><div class='headline_description' style='width: "+a.xy.map_description_width+"px;'>"+d.description+"</div></div>";a._table_view=!0;a.set_sizes()}}function h(){a._selected_event_id=null;a.map._infowindow.close();var b=a.map._markers,d;for(d in b)b.hasOwnProperty(d)&&(b[d].setMap(null),delete a.map._markers[d],a.map._infowindows_content[d]&&delete a.map._infowindows_content[d])}function f(){var b=a.get_visible_events();
b.sort(function(a,b){return a.start_date.valueOf()==b.start_date.valueOf()?a.id>b.id?1:-1:a.start_date>b.start_date?1:-1});for(var d="<div class='dhx_map_area'>",e=0;e<b.length;e++){var c=b[e],i=c.id==a._selected_event_id?"dhx_map_line highlight":"dhx_map_line",f=c.color?"background:"+c.color+";":"",m=c.textColor?"color:"+c.textColor+";":"";d+="<div class='"+i+"' event_id='"+c.id+"' style='"+f+""+m+""+(c._text_style||"")+" width: "+(a.xy.map_date_width+a.xy.map_description_width+2)+"px;'><div style='width: "+
a.xy.map_date_width+"px;' >"+a.templates.map_time(c.start_date,c.end_date,c)+"</div>";d+="<div class='dhx_event_icon icon_details'>&nbsp</div>";d+="<div class='line_description' style='width:"+(a.xy.map_description_width-25)+"px;'>"+a.templates.map_text(c.start_date,c.end_date,c)+"</div></div>"}d+="<div class='dhx_v_border' style='left: "+(a.xy.map_date_width-2)+"px;'></div><div class='dhx_v_border_description'></div></div>";a._els.dhx_cal_data[0].scrollTop=0;a._els.dhx_cal_data[0].innerHTML=d;a._els.dhx_cal_data[0].style.width=
a.xy.map_date_width+a.xy.map_description_width+1+"px";var g=a._els.dhx_cal_data[0].firstChild.childNodes;a._els.dhx_cal_date[0].innerHTML=a.templates[a._mode+"_date"](a._min_date,a._max_date,a._mode);a._rendered=[];for(e=0;e<g.length-2;e++)a._rendered[e]=g[e]}function l(b){var d=document.getElementById(b),e=a._y-a.xy.nav_height;e<0&&(e=0);var c=a._x-a.xy.map_date_width-a.xy.map_description_width-1;c<0&&(c=0);d.style.height=e+"px";d.style.width=c+"px";d.style.marginLeft=a.xy.map_date_width+a.xy.map_description_width+
1+"px";d.style.marginTop=a.xy.nav_height+2+"px"}(function(){a._isMapPositionSet=!1;var b=document.createElement("div");b.className="dhx_map";b.id="dhx_gmap";b.style.dispay="none";var d=a._obj;d.appendChild(b);a._els.dhx_gmap=[];a._els.dhx_gmap.push(b);l("dhx_gmap");var e={zoom:a.config.map_inital_zoom||10,center:a.config.map_initial_position,mapTypeId:a.config.map_type||google.maps.MapTypeId.ROADMAP},c=new google.maps.Map(document.getElementById("dhx_gmap"),e);c.disableDefaultUI=!1;c.disableDoubleClickZoom=
!a.config.readonly;google.maps.event.addListener(c,"dblclick",function(b){if(!a.config.readonly&&a.config.dblclick_create){var c=b.latLng;geocoder.geocode({latLng:c},function(b,d){if(d==google.maps.GeocoderStatus.OK)c=b[0].geometry.location,a.addEventNow({lat:c.lat(),lng:c.lng(),event_location:b[0].formatted_address,start_date:a._date,end_date:a.date.add(a._date,a.config.time_step,"minute")})})}});var f={content:""};if(a.config.map_infowindow_max_width)f.maxWidth=a.config.map_infowindow_max_width;
a.map={_points:[],_markers:[],_infowindow:new google.maps.InfoWindow(f),_infowindows_content:[],_initialization_count:-1,_obj:c};geocoder=new google.maps.Geocoder;a.config.map_resolve_user_location&&navigator.geolocation&&(a._isMapPositionSet||navigator.geolocation.getCurrentPosition(function(b){var d=new google.maps.LatLng(b.coords.latitude,b.coords.longitude);c.setCenter(d);c.setZoom(a.config.map_zoom_after_resolve||10);a.map._infowindow.setContent(a.locale.labels.marker_geo_success);a.map._infowindow.position=
c.getCenter();a.map._infowindow.open(c);a._isMapPositionSet=!0},function(){a.map._infowindow.setContent(a.locale.labels.marker_geo_fail);a.map._infowindow.setPosition(c.getCenter());a.map._infowindow.open(c);a._isMapPositionSet=!0}));google.maps.event.addListener(c,"resize",function(){b.style.zIndex="5";c.setZoom(c.getZoom())});google.maps.event.addListener(c,"tilesloaded",function(){b.style.zIndex="5"});b.style.display="none"})();a.attachEvent("onSchedulerResize",function(){return this._mode=="map"?
(this.map_view(!0),!1):!0});var n=a.render_data;a.render_data=function(b,d){if(this._mode=="map"){f();for(var e=a.get_visible_events(),c=0;c<e.length;c++)a.map._markers[e[c].id]||j(e[c],!1,!1)}else return n.apply(this,arguments)};a.map_view=function(b){a.map._initialization_count++;var d=a._els.dhx_gmap[0];a._els.dhx_cal_data[0].style.width=a.xy.map_date_width+a.xy.map_description_width+1+"px";a._min_date=a.config.map_start||a._currentDate();a._max_date=a.config.map_end||a.date.add(a._currentDate(),
1,"year");a._table_view=!0;g(b);if(b){h();f();d.style.display="block";l("dhx_gmap");for(var e=a.map._obj.getCenter(),c=a.get_visible_events(),i=0;i<c.length;i++)a.map._markers[c[i].id]||j(c[i])}else d.style.display="none";google.maps.event.trigger(a.map._obj,"resize");a.map._initialization_count===0&&e&&a.map._obj.setCenter(e);a._selected_event_id&&o(a._selected_event_id)};var o=function(b){a.map._obj.setCenter(a.map._points[b]);a.callEvent("onClick",[b])},j=function(b,d,e){var c=a.config.map_error_position;
b.lat&&b.lng&&(c=new google.maps.LatLng(b.lat,b.lng));var f=a.templates.marker_text(b.start_date,b.end_date,b);a._new_event||(a.map._infowindows_content[b.id]=f,a.map._markers[b.id]&&a.map._markers[b.id].setMap(null),a.map._markers[b.id]=new google.maps.Marker({position:c,map:a.map._obj}),google.maps.event.addListener(a.map._markers[b.id],"click",function(){a.map._infowindow.setContent(a.map._infowindows_content[b.id]);a.map._infowindow.open(a.map._obj,a.map._markers[b.id]);a._selected_event_id=b.id;
a.render_data()}),a.map._points[b.id]=c,d&&a.map._obj.setCenter(a.map._points[b.id]),e&&a.callEvent("onClick",[b.id]))};a.attachEvent("onClick",function(b){if(this._mode=="map"){a._selected_event_id=b;for(var d=0;d<a._rendered.length;d++)a._rendered[d].className="dhx_map_line",a._rendered[d].getAttribute("event_id")==b&&(a._rendered[d].className+=" highlight");a.map._points[b]&&a.map._markers[b]&&(a.map._obj.setCenter(a.map._points[b]),google.maps.event.trigger(a.map._markers[b],"click"))}return!0});
var k=function(b){b.event_location&&geocoder?geocoder.geocode({address:b.event_location,language:a.uid().toString()},function(d,e){var c={};if(e!=google.maps.GeocoderStatus.OK){if(c=a.callEvent("onLocationError",[b.id]),!c||c===!0)c=a.config.map_error_position}else c=d[0].geometry.location;b.lat=c.lat();b.lng=c.lng();a._selected_event_id=b.id;a._latLngUpdate=!0;a.callEvent("onEventChanged",[b.id,b]);j(b,!0,!0)}):j(b,!0,!0)},p=function(b){b.event_location&&geocoder&&geocoder.geocode({address:b.event_location,
language:a.uid().toString()},function(d,e){var c={};if(e!=google.maps.GeocoderStatus.OK){if(c=a.callEvent("onLocationError",[b.id]),!c||c===!0)c=a.config.map_error_position}else c=d[0].geometry.location;b.lat=c.lat();b.lng=c.lng();a._latLngUpdate=!0;a.callEvent("onEventChanged",[b.id,b])})},q=function(a,d,e,c){setTimeout(function(){var c=a.apply(d,e);a=d=e=null;return c},c||1)};a.attachEvent("onEventChanged",function(b){if(this._latLngUpdate)this._latLngUpdate=!1;else{var d=a.getEvent(b);d.start_date<
a._min_date&&d.end_date>a._min_date||d.start_date<a._max_date&&d.end_date>a._max_date||d.start_date.valueOf()>=a._min_date&&d.end_date.valueOf()<=a._max_date?(a.map._markers[b]&&a.map._markers[b].setMap(null),k(d)):(a._selected_event_id=null,a.map._infowindow.close(),a.map._markers[b]&&a.map._markers[b].setMap(null))}return!0});a.attachEvent("onEventIdChange",function(b,d){var e=a.getEvent(d);if(e.start_date<a._min_date&&e.end_date>a._min_date||e.start_date<a._max_date&&e.end_date>a._max_date||e.start_date.valueOf()>=
a._min_date&&e.end_date.valueOf()<=a._max_date)a.map._markers[b]&&(a.map._markers[b].setMap(null),delete a.map._markers[b]),a.map._infowindows_content[b]&&delete a.map._infowindows_content[b],k(e);return!0});a.attachEvent("onEventAdded",function(b,d){if(!a._dataprocessor&&(d.start_date<a._min_date&&d.end_date>a._min_date||d.start_date<a._max_date&&d.end_date>a._max_date||d.start_date.valueOf()>=a._min_date&&d.end_date.valueOf()<=a._max_date))a.map._markers[b]&&a.map._markers[b].setMap(null),k(d);
return!0});a.attachEvent("onBeforeEventDelete",function(b){a.map._markers[b]&&a.map._markers[b].setMap(null);a._selected_event_id=null;a.map._infowindow.close();return!0});a._event_resolve_delay=1500;a.attachEvent("onEventLoading",function(b){a.config.map_resolve_event_location&&b.event_location&&!b.lat&&!b.lng&&(a._event_resolve_delay+=1500,q(p,this,[b],a._event_resolve_delay));return!0});a.attachEvent("onEventCancel",function(b,d){d&&(a.map._markers[b]&&a.map._markers[b].setMap(null),a.map._infowindow.close());
return!0})})});
