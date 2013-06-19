/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
To use this component please contact sales@dhtmlx.com to obtain license
*/
Scheduler.plugin(function(a){a._props={};a.createUnitsView=function(b,c,k,h,l,m){if(typeof b=="object")k=b.list,c=b.property,h=b.size||0,l=b.step||1,m=b.skip_incorrect,b=b.name;a._props[b]={map_to:c,options:k,step:l,position:0};if(h>a._props[b].options.length)a._props[b]._original_size=h,h=0;a._props[b].size=h;a._props[b].skip_incorrect=m||!1;a.date[b+"_start"]=a.date.day_start;a.templates[b+"_date"]=function(b){return a.templates.day_date(b)};a._get_unit_index=function(b,n){var i=b.position||0,c=
Math.floor((a._correct_shift(+n,1)-+a._min_date)/864E5);return i+c};a.templates[b+"_scale_text"]=function(a,b,i){return i.css?"<span class='"+i.css+"'>"+b+"</span>":b};a.templates[b+"_scale_date"]=function(f){var c=a._props[b],i=c.options;if(!i.length)return"";var h=a._get_unit_index(c,f),e=i[h];return a.templates[b+"_scale_text"](e.key,e.label,e)};a.date["add_"+b]=function(b,c){return a.date.add(b,c,"day")};a.date["get_"+b+"_end"]=function(f){return a.date.add(f,a._props[b].size||a._props[b].options.length,
"day")};a.attachEvent("onOptionsLoad",function(){for(var f=a._props[b],c=f.order={},i=f.options,h=0;h<i.length;h++)c[i[h].key]=h;if(f._original_size&&f.size==0)f.size=f._original_size,delete f.original_size;f.size>i.length?(f._original_size=f.size,f.size=0):f.size=f._original_size||f.size;a._date&&a._mode==b&&a.setCurrentView(a._date,a._mode)});a.callEvent("onOptionsLoad",[])};a.scrollUnit=function(b){var c=a._props[this._mode];if(c)c.position=Math.min(Math.max(0,c.position+b),c.options.length-c.size),
this.update_view()};(function(){var b=function(e){var d=a._props[a._mode];if(d&&d.order&&d.skip_incorrect){for(var b=[],g=0;g<e.length;g++)typeof d.order[e[g][d.map_to]]!="undefined"&&b.push(e[g]);e.splice(0,e.length);e.push.apply(e,b)}return e},c=a._pre_render_events_table;a._pre_render_events_table=function(a,d){a=b(a);return c.apply(this,[a,d])};var k=a._pre_render_events_line;a._pre_render_events_line=function(a,d){a=b(a);return k.apply(this,[a,d])};var h=function(e,d){if(e&&typeof e.order[d[e.map_to]]==
"undefined"){var b=a,g=864E5,f=Math.floor((d.end_date-b._min_date)/g);d[e.map_to]=e.options[Math.min(f+e.position,e.options.length-1)].key;return!0}},l=a._reset_scale,m=a.is_visible_events;a.is_visible_events=function(e){var b=m.apply(this,arguments);if(b){var j=a._props[this._mode];if(j&&j.size){var g=j.order[e[j.map_to]];if(g<j.position||g>=j.size+j.position)return!1}}return b};a._reset_scale=function(){var e=a._props[this._mode],b=l.apply(this,arguments);if(e){this._max_date=this.date.add(this._min_date,
1,"day");for(var j=this._els.dhx_cal_data[0].childNodes,g=0;g<j.length;g++)j[g].className=j[g].className.replace("_now","");if(e.size&&e.size<e.options.length){var f=this._els.dhx_cal_header[0],c=document.createElement("DIV");if(e.position)c.className="dhx_cal_prev_button",c.style.cssText="left:1px;top:2px;position:absolute;",c.innerHTML="&nbsp;",f.firstChild.appendChild(c),c.onclick=function(){a.scrollUnit(e.step*-1)};if(e.position+e.size<e.options.length)c=document.createElement("DIV"),c.className=
"dhx_cal_next_button",c.style.cssText="left:auto; right:0px;top:2px;position:absolute;",c.innerHTML="&nbsp;",f.lastChild.appendChild(c),c.onclick=function(){a.scrollUnit(e.step)}}}return b};var f=a._get_event_sday;a._get_event_sday=function(b){var d=a._props[this._mode];return d?(h(d,b),d.order[b[d.map_to]]-d.position):f.call(this,b)};var n=a.locate_holder_day;a.locate_holder_day=function(b,d,c){var g=a._props[this._mode];return g&&c?(h(g,c),g.order[c[g.map_to]]*1+(d?1:0)-g.position):n.apply(this,
arguments)};var i=a._mouse_coords;a._mouse_coords=function(){var b=a._props[this._mode],d=i.apply(this,arguments);if(b){if(!this._drag_event)this._drag_event={};var c=this._drag_event;if(this._drag_id&&this._drag_mode)c=this.getEvent(this._drag_id),this._drag_event._dhx_changed=!0;var g=Math.min(d.x+b.position,b.options.length-1),f=b.map_to;d.section=c[f]=b.options[g].key;d.x=0}d.force_redraw=!0;return d};var o=a._time_order;a._time_order=function(b){var d=a._props[this._mode];d?b.sort(function(a,
b){return d.order[a[d.map_to]]>d.order[b[d.map_to]]?1:-1}):o.apply(this,arguments)};a.attachEvent("onEventAdded",function(b,d){if(this._loading)return!0;for(var c in a._props){var g=a._props[c];if(typeof d[g.map_to]=="undefined")d[g.map_to]=g.options[0].key}return!0});a.attachEvent("onEventCreated",function(b,c){var f=a._props[this._mode];if(f&&c){var g=this.getEvent(b);this._mouse_coords(c);h(f,g);this.event_updated(g)}return!0})})()});
