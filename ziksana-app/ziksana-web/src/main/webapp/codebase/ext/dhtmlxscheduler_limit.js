/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
To use this component please contact sales@dhtmlx.com to obtain license
*/
Scheduler.plugin(function(a){a.config.limit_start=null;a.config.limit_end=null;a.config.limit_view=!1;a.config.check_limits=!0;a.config.mark_now=!0;a.config.display_marked_timespans=!0;(function(){var x=null,t="dhx_time_block",G=function(a,b,c){b instanceof Date&&c instanceof Date?(a.start_date=b,a.end_date=c):(a.days=b,a.zones=c);return a},F=function(a,b,c){var e=typeof a=="object"?a:{days:a};e.type=t;e.css="";if(b){if(c)e.sections=c;e=G(e,a,b)}return e};a.blockTime=function(d,b,c){var e=F(d,b,c);
return a.addMarkedTimespan(e)};a.unblockTime=function(d,b,c){var b=b||"fullday",e=F(d,b,c);return a.deleteMarkedTimespan(e)};a.attachEvent("onBeforeViewChange",function(d,b,c,e){e=e||b;c=c||d;return a.config.limit_view&&(e.valueOf()>a.config.limit_end.valueOf()||this.date.add(e,1,c)<=a.config.limit_start.valueOf())?(setTimeout(function(){a.setCurrentView(a._date,c)},1),!1):!0});var B=function(a,b,c){var e=c[b]&&c[b][t]?c[b][t]:c[a]&&c[a][t]?c[a][t]:[];return e},u=function(d){if(!d)return!0;if(!a.config.check_limits)return!0;
for(var b=a,c=b._mode,e=a._marked_timespans,f=b.config,h=[],h=d.rec_type?a.getRecDates(d):[d],i=!0,j=0;j<h.length;j++){var g=h[j];g._timed=a.is_one_day_event(g);if(i=f.limit_start&&f.limit_end?g.start_date.valueOf()>=f.limit_start.valueOf()&&g.end_date.valueOf()<=f.limit_end.valueOf():!0)for(var k=new Date(g.start_date.valueOf()),p=a.date.add(k,1,"day");k<g.end_date;k=a.date.date_part(p),p=b.date.add(k,1,"day")){var o=+a.date.date_part(new Date(k)),q=k.getDay(),l=[];if(b._props&&b._props[c]){var m=
b._props[c],r=e[c];if(r&&r[g[m.map_to]])for(var s=r[g[m.map_to]],A=B(q,o,s),n=0;n<A.length;n++)l=a._add_timespan_zones(l,A[n].zones)}if(b.matrix&&b.matrix[c]){var t=b.matrix[c],u=e[c];if(u&&u[g[t.y_property]])for(var x=u[g[t.y_property]],C=B(q,o,x),n=0;n<C.length;n++)l=a._add_timespan_zones(l,C[n].zones)}for(var E=e.global,D=B(q,o,E),n=0;n<D.length;n++)l=a._add_timespan_zones(l,D[n].zones);if(l)for(n=0;n<l.length;n+=2){var y=a._get_zone_minutes(k),w=g.end_date>p||g.end_date.getDate()!=k.getDate()?
1440:a._get_zone_minutes(g.end_date),z=l[n],v=l[n+1];if(z<w&&v>y){if(y<=v&&y>=z){if(v==1440||w<v){i=!1;break}if(g._timed&&b._drag_id&&b._drag_mode=="new-size")g.start_date.setHours(0),g.start_date.setMinutes(v);else{i=!1;break}}if(w>=z&&w<v||y<z&&w>v)if(g._timed&&b._drag_id&&b._drag_mode=="new-size")g.end_date.setHours(0),g.end_date.setMinutes(z);else{i=!1;break}}}}if(!i)b._drag_id=null,b._drag_mode=null,i=b.checkEvent("onLimitViolation")?b.callEvent("onLimitViolation",[g.id,g]):i}return i};a.attachEvent("onMouseDown",
function(a){return!(a=t)});a.attachEvent("onBeforeDrag",function(d){return!d?!0:u(a.getEvent(d))});a.attachEvent("onClick",function(d){return u(a.getEvent(d))});a.attachEvent("onBeforeLightbox",function(d){var b=a.getEvent(d);x=[b.start_date,b.end_date];return u(b)});a.attachEvent("onEventSave",function(d,b){if(b.rec_type){var c=a._lame_clone(b);a._roll_back_dates(c)}return u(b)});a.attachEvent("onEventAdded",function(d){if(!d)return!0;var b=a.getEvent(d);if(!u(b)&&a.config.limit_start&&a.config.limit_end){if(b.start_date<
a.config.limit_start)b.start_date=new Date(a.config.limit_start);if(b.start_date.valueOf()>=a.config.limit_end.valueOf())b.start_date=this.date.add(a.config.limit_end,-1,"day");if(b.end_date<a.config.limit_start)b.end_date=new Date(a.config.limit_start);if(b.end_date.valueOf()>=a.config.limit_end.valueOf())b.end_date=this.date.add(a.config.limit_end,-1,"day");if(b.start_date.valueOf()>=b.end_date.valueOf())b.end_date=this.date.add(b.start_date,this.config.event_duration||this.config.time_step,"minute");
b._timed=this.is_one_day_event(b)}return!0});a.attachEvent("onEventChanged",function(d){if(!d)return!0;var b=a.getEvent(d);if(!u(b)){if(!x)return!1;b.start_date=x[0];b.end_date=x[1];b._timed=this.is_one_day_event(b)}return!0});a.attachEvent("onBeforeEventChanged",function(a){return u(a)});a.attachEvent("onBeforeEventCreated",function(d){var b=a.getActionData(d).date,c={_timed:!0,start_date:b,end_date:a.date.add(b,a.config.time_step,"minute")};return u(c)});a.attachEvent("onViewChange",function(){a.markNow()});
a.attachEvent("onSchedulerResize",function(){window.setTimeout(function(){a.markNow()},1);return!0});a.attachEvent("onTemplatesReady",function(){a._mark_now_timer=window.setInterval(function(){a.markNow()},6E4)});a.markNow=function(d){var b="dhx_now_time";this._els[b]||(this._els[b]=[]);var c=a._currentDate(),e=this.config;a._remove_mark_now();if(!d&&e.mark_now&&c<this._max_date&&c>this._min_date&&c.getHours()>=e.first_hour&&c.getHours()<e.last_hour){var f=this.locate_holder_day(c);this._els[b]=a._append_mark_now(f,
c)}};a._append_mark_now=function(d,b){var c="dhx_now_time",e=a._get_zone_minutes(b),f={zones:[e,e+1],css:c,type:c};if(this._table_view){if(this._mode=="month")return f.days=+a.date.date_part(b),a._render_marked_timespan(f,null,null)}else if(this._props&&this._props[this._mode]){for(var h=this._els.dhx_cal_data[0].childNodes,i=[],j=0;j<h.length-1;j++){var g=d+j;f.days=g;var k=a._render_marked_timespan(f,null,g)[0];i.push(k)}return i}else return f.days=d,a._render_marked_timespan(f,null,d)};a._remove_mark_now=
function(){for(var a="dhx_now_time",b=this._els[a],c=0;c<b.length;c++){var e=b[c],f=e.parentNode;f&&f.removeChild(e)}this._els[a]=[]};a._marked_timespans={global:{}};a._get_zone_minutes=function(a){return a.getHours()*60+a.getMinutes()};a._prepare_timespan_options=function(d){var b=[],c=[];if(d.days=="fullweek")d.days=[0,1,2,3,4,5,6];if(d.days instanceof Array){for(var e=d.days.slice(),f=0;f<e.length;f++){var h=a._lame_clone(d);h.days=e[f];b.push.apply(b,a._prepare_timespan_options(h))}return b}if(!d||
!(d.start_date&&d.end_date&&d.end_date>d.start_date||d.days!==void 0&&d.zones))return b;var i=0,j=1440;if(d.zones=="fullday")d.zones=[i,j];if(d.zones&&d.invert_zones)d.zones=a.invertZones(d.zones);d.id=a.uid();d.css=d.css||"";d.type=d.type||"default";var g=d.sections;if(g)for(var k in g){if(g.hasOwnProperty(k)){var p=g[k];p instanceof Array||(p=[p]);for(f=0;f<p.length;f++){var o=a._lame_copy({},d);o.sections={};o.sections[k]=p[f];c.push(o)}}}else c.push(d);for(var q=0;q<c.length;q++){var l=c[q],m=
l.start_date,r=l.end_date;if(m&&r)for(var s=a.date.date_part(new Date(m)),A=a.date.add(s,1,"day");s<r;){o=a._lame_copy({},l);delete o.start_date;delete o.end_date;o.days=s.valueOf();var n=m>s?a._get_zone_minutes(m):i,t=r>A||r.getDate()!=s.getDate()?j:a._get_zone_minutes(r);o.zones=[n,t];b.push(o);s=A;A=a.date.add(A,1,"day")}else{if(l.days instanceof Date)l.days=a.date.date_part(l.days).valueOf();l.zones=d.zones.slice();b.push(l)}}return b};a._get_dates_by_index=function(d,b,c){for(var e=[],b=a.date.date_part(new Date(b||
a._min_date)),c=new Date(c||a._max_date),f=b.getDay(),h=d-f>=0?d-f:7-b.getDay()+d,i=a.date.add(b,h,"day");i<c;i=a.date.add(i,1,"week"))e.push(i);return e};a._get_css_classes_by_config=function(a){var b=[];a.type==t&&(b.push(t),a.css&&b.push(t+"_reset"));b.push("dhx_marked_timespan",a.css);return b.join(" ")};a._get_block_by_config=function(a){var b=document.createElement("DIV");if(a.html)typeof a.html=="string"?b.innerHTML=a.html:b.appendChild(a.html);return b};a._render_marked_timespan=function(d,
b,c){var e=[],f=a.config,h=this._min_date,i=this._max_date,j=!1;if(!f.display_marked_timespans)return e;if(!c&&c!==0){if(d.days<7)c=d.days;else{var g=new Date(d.days),j=+g;if(!(+i>=+g&&+h<=+g))return e;c=g.getDay()}var k=h.getDay();k>c?c=7-(k-c):c-=k}var p=d.zones,o=a._get_css_classes_by_config(d);if(a._table_view&&a._mode=="month"){var q=[],l=[];if(b)q.push(b),l.push(c);else for(var l=j?[j]:a._get_dates_by_index(c),m=0;m<l.length;m++)q.push(this._scales[l[m]]);for(m=0;m<q.length;m++)for(var b=q[m],
c=l[m],r=0;r<p.length;r+=2){var s=p[m],t=p[m+1];if(t<=s)return[];var n=a._get_block_by_config(d);n.className=o;var u=b.offsetHeight-1,x=b.offsetWidth-1,B=Math.floor((this._correct_shift(c,1)-h.valueOf())/(864E5*this._cols.length)),C=this.locate_holder_day(c,!1)%this._cols.length,E=this._colsS[C],D=this._colsS.heights[B]+(this._colsS.height?this.xy.month_scale_height+2:2)-1;n.style.top=D+"px";n.style.lineHeight=n.style.height=u+"px";n.style.left=E+Math.round(s/1440*x)+"px";n.style.width=Math.round((t-
s)/1440*x)+"px";b.appendChild(n);e.push(n)}}else{var y=c;if(this._props&&this._props[this._mode]&&d.sections&&d.sections[this._mode]){var w=this._props[this._mode],y=w.order[d.sections[this._mode]];w.size&&y>w.position+w.size&&(y=0)}b=b?b:a.locate_holder(y);for(m=0;m<p.length;m+=2){s=Math.max(p[m],f.first_hour*60);t=Math.min(p[m+1],f.last_hour*60);if(t<=s)if(m+2<p.length)continue;else return[];n=a._get_block_by_config(d);n.className=o;var z=this.config.hour_size_px*24+1,v=36E5;n.style.top=Math.round((s*
6E4-this.config.first_hour*v)*this.config.hour_size_px/v)%z+"px";n.style.lineHeight=n.style.height=Math.max(Math.round((t-s)*6E4*this.config.hour_size_px/v)%z,1)+"px";b.appendChild(n);e.push(n)}}return e};a.markTimespan=function(d){var b=a._prepare_timespan_options(d);if(b.length){for(var c=[],e=0;e<b.length;e++){var f=b[e],h=a._render_marked_timespan(f,null,null);h.length&&c.push.apply(c,h)}return c}};a.unmarkTimespan=function(a){if(a)for(var b=0;b<a.length;b++){var c=a[b];c.parentNode&&c.parentNode.removeChild(c)}};
a._marked_timespans_ids={};a.addMarkedTimespan=function(d){var b=a._prepare_timespan_options(d),c="global";if(b.length){var e=b[0].id,f=a._marked_timespans,h=a._marked_timespans_ids;h[e]||(h[e]=[]);for(var i=0;i<b.length;i++){var j=b[i],g=j.days,k=j.zones,p=j.css,o=j.sections,q=j.type;j.id=e;if(o)for(var l in o){if(o.hasOwnProperty(l)){f[l]||(f[l]={});var m=o[l],r=f[l];r[m]||(r[m]={});r[m][g]||(r[m][g]={});r[m][g][q]||(r[m][g][q]=[]);var s=r[m][g][q];j._array=s;s.push(j);h[e].push(j)}}else f[c][g]||
(f[c][g]={}),f[c][g][q]||(f[c][g][q]=[]),s=f[c][g][q],j._array=s,s.push(j),h[e].push(j)}return e}};a._add_timespan_zones=function(a,b){var c=a.slice(),b=b.slice();if(!c.length)return b;for(var e=0;e<c.length;e+=2)for(var f=c[e],h=c[e+1],i=e+2==c.length,j=0;j<b.length;j+=2){var g=b[j],k=b[j+1];if(k>h&&g<=h||g<f&&k>=f)c[e]=Math.min(f,g),c[e+1]=Math.max(h,k),e-=2;else{if(!i)continue;var p=f>g?0:2;c.splice(e+p,0,g,k)}b.splice(j--,2);break}return c};a._subtract_timespan_zones=function(a,b){for(var c=a.slice(),
e=0;e<c.length;e+=2)for(var f=c[e],h=c[e+1],i=0;i<b.length;i+=2){var j=b[i],g=b[i+1];if(g>f&&j<h){var k=!1;f>=j&&h<=g&&c.splice(e,2);f<j&&(c.splice(e,2,f,j),k=!0);h>g&&c.splice(k?e+2:e,k?0:2,g,h);e-=2;break}}return c};a.invertZones=function(d){return a._subtract_timespan_zones([0,1440],d.slice())};a._delete_marked_timespan_by_id=function(d){var b=a._marked_timespans_ids[d];if(b)for(var c=0;c<b.length;c++)for(var e=b[c],f=e._array,h=0;h<f.length;h++)if(f[h]==e){f.splice(h,1);break}};a._delete_marked_timespan_by_config=
function(d){var b=a._marked_timespans,c=d.sections,e=d.days,f=d.type||"default",h=[];if(c)for(var i in c){if(c.hasOwnProperty(i)&&b[i]){var j=c[i];b[i][j]&&b[i][j][e]&&b[i][j][e][f]&&(h=b[i][j][e][f])}}else b.global[e]&&b.global[e][f]&&(h=b.global[e][f]);for(var g=0;g<h.length;g++){var k=h[g],p=a._subtract_timespan_zones(k.zones,d.zones);if(p.length)k.zones=p;else{h.splice(g,1);g--;for(var o=a._marked_timespans_ids[k.id],q=0;q<o.length;q++)if(o[q]==k){o.splice(q,1);break}}}};a.deleteMarkedTimespan=
function(d){if(!arguments.length)a._marked_timespans={global:{}},a._marked_timespans_ids={};if(typeof d!="object")a._delete_marked_timespan_by_id(d);else for(var b=a._prepare_timespan_options(d),c=0;c<b.length;c++){var e=b[c];a._delete_marked_timespan_by_config(b[c])}};a._get_types_to_render=function(a,b){var c=a?a:{},e;for(e in b||{})b.hasOwnProperty(e)&&(c[e]=b[e]);return c};a._get_configs_to_render=function(a){var b=[],c;for(c in a)a.hasOwnProperty(c)&&b.push.apply(b,a[c]);return b};a.attachEvent("onScaleAdd",
function(d,b){if(!(a._table_view&&a._mode!="month")){var c=b.getDay(),e=b.valueOf(),f=this._mode,h=a._marked_timespans,i=[];if(this._props&&this._props[f]){var j=this._props[f],g=j.options,k=a._get_unit_index(j,b),p=g[k],b=a.date.date_part(new Date(this._date)),c=b.getDay(),e=b.valueOf();if(h[f]&&h[f][p.key]){var o=h[f][p.key],q=a._get_types_to_render(o[c],o[e]);i.push.apply(i,a._get_configs_to_render(q))}}var l=h.global,m=l[e]||l[c];i.push.apply(i,a._get_configs_to_render(m));for(var r=0;r<i.length;r++)a._render_marked_timespan(i[r],
d,b)}})})()});
