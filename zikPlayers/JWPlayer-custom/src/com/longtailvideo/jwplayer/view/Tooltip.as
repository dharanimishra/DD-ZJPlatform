﻿/*Copyright (c) 2012 Meurrens JonathanThis program is free software: you can redistribute it and/or modifyit under the terms of the GNU General Public License as published bythe Free Software Foundation, either version 3 of the License, or(at your option) any later version.	This program is distributed in the hope that it will be useful,but WITHOUT ANY WARRANTY; without even the implied warranty ofMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See theGNU General Public License for more details.	You should have received a copy of the GNU General Public Licensealong with this program.  If not, see <http://www.gnu.org/licenses/>.*/package com.longtailvideo.jwplayer.view{		import flash.display.DisplayObject;	import flash.display.MovieClip;	import flash.errors.IllegalOperationError;	import flash.events.MouseEvent;	import flash.text.StyleSheet;	import flash.text.TextField;	import flash.text.TextFieldAutoSize;	public class Tooltip extends MovieClip	{		private static var _tooltip:MovieClip;		private static var _styleSheet:StyleSheet;		private static var _label:TextField;				private static var _currentObject:DisplayObject;		private static var _margin:uint=10;				private static var allowInstance:Boolean = false;				public function Tooltip(text:String="")		{			if (!allowInstance) 			{				throw(new IllegalOperationError("This is a singleton class, no instance allowed, use Tooltip.subscribe()"));				return;			}		}				public static function subscribe(object:DisplayObject):void		{			object.addEventListener(MouseEvent.MOUSE_OVER,doTooltip);		}				public static function unsubscribe(object:DisplayObject):void		{			if(object.hasEventListener(MouseEvent.MOUSE_OVER))				object.removeEventListener(MouseEvent.MOUSE_OVER,doTooltip);		}				private static function doTooltip(e:MouseEvent):void		{				_currentObject = DisplayObject(e.currentTarget);						_currentObject.addEventListener(MouseEvent.MOUSE_OUT,hideTooltip);			_currentObject.addEventListener(MouseEvent.MOUSE_DOWN,hideTooltip);						if(_tooltip==null && _label==null)			{				_tooltip = new MovieClip();				_label = new TextField();												_label.antiAliasType=flash.text.AntiAliasType.ADVANCED;				_label.selectable=false;				_label.embedFonts=false;								_label.styleSheet = getStyleSheet();				_label.htmlText="<p>"+Object(_currentObject).tooltipLabel+"</p>";				_label.autoSize=TextFieldAutoSize.LEFT;								_tooltip.graphics.beginFill(0x111111,0.75);				_tooltip.graphics.drawRoundRect(0,0,_label.width+15,_label.height+3,5,5);				_tooltip.graphics.endFill();								_label.x=15/2;				_label.y=2;				_tooltip.addChild(_label);				_currentObject.stage.addChild(_tooltip);				_currentObject.stage.addEventListener(MouseEvent.MOUSE_MOVE,updateTooltipPos);								_tooltip.x=e.stageX+_margin;				_tooltip.y=e.stageY+_margin;			}			else			{				_label.htmlText="<p>"+Object(_currentObject).tooltipLabel+"</p>";				_tooltip.graphics.clear();				_tooltip.graphics.beginFill(0x111111,0.75);				_tooltip.graphics.drawRoundRect(0,0,_label.width+15,_label.height+3,5,5);				_tooltip.graphics.endFill();				_tooltip.visible=true;			}					}				private static function hideTooltip(e:MouseEvent):void		{			_tooltip.visible=false;						DisplayObject(e.currentTarget).removeEventListener(MouseEvent.MOUSE_OUT,hideTooltip);			DisplayObject(e.currentTarget).removeEventListener(MouseEvent.MOUSE_DOWN,hideTooltip);		}				private static function updateTooltipPos(e:MouseEvent):void		{			_tooltip.x=e.stageX+_margin;			_tooltip.y=e.stageY+_margin;		}				private static function getStyleSheet():StyleSheet		{			var css:StyleSheet;			if(_styleSheet==null)			{				css = new StyleSheet();				css.parseCSS("p{color:#FFFFFF;}");			}			else				css=_styleSheet;			return css;		}				public static function setStyleSheet(css:StyleSheet):void		{			_label.styleSheet = _styleSheet = css;		}	}}