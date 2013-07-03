/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
To use this component please contact sales@dhtmlx.com to obtain license
*/
Scheduler.plugin(function(a){(function(){a.grid={sort_rules:{"int":function(a,e,b){return b(a)*1<b(e)*1?1:-1},str:function(a,e,b){return b(a)<b(e)?1:-1},date:function(a,e,b){return new Date(b(a))<new Date(b(e))?1:-1}},_getObjName:function(a){return"grid_"+a},_getViewName:function(a){return a.replace(/^grid_/,"")}}})();a.createGridView=function(c){function e(a){return!(a!==void 0&&(a*1!=a||a<0))}var b=c.name||"grid",d=a.grid._getObjName(b);a.config[b+"_start"]=c.from||new Date(0);a.config[b+"_end"]=
c.to||new Date(9999,1,1);a[d]=c;a[d].defPadding=8;a[d].columns=a[d].fields;delete a[d].fields;for(var f=a[d].columns,g=0;g<f.length;g++){if(e(f[g].width))f[g].initialWidth=f[g].width;e(f[g].paddingLeft)||delete f[g].paddingLeft;e(f[g].paddingRight)||delete f[g].paddingRight}a[d].select=c.select===void 0?!0:c.select;a.locale.labels[b+"_tab"]===void 0&&(a.locale.labels[b+"_tab"]=a[d].label||a.locale.labels.grid_tab);a[d]._selected_divs=[];a.date[b+"_start"]=function(a){return a};a.date["add_"+b]=function(a,
b){var c=new Date(a);c.setMonth(c.getMonth()+b);return c};a.templates[b+"_date"]=function(b,c){return a.templates.day_date(b)+" - "+a.templates.day_date(c)};a.attachEvent("onTemplatesReady",function(){a.templates[b+"_full_date"]=function(b,c,d){return d._timed?this.day_date(d.start_date,d.end_date,d)+" "+this.event_date(b):a.templates.day_date(b)+" &ndash; "+a.templates.day_date(c)};a.templates[b+"_single_date"]=function(b){return a.templates.day_date(b)+" "+this.event_date(b)};a.attachEvent("onDblClick",
function(c){return this._mode==b?(a._click.buttons.details(c),!1):!0});a.attachEvent("onClick",function(c,e){return this._mode==b&&a[d].select?(a.grid.unselectEvent("",b),a.grid.selectEvent(c,b,e),!1):!0});a.templates[b+"_field"]=function(a,b){return b[a]};a.attachEvent("onSchedulerResize",function(){return this._mode==b?(this[b+"_view"](!0),window.setTimeout(function(){a.callEvent("onAfterSchedulerResize",[])},1),!1):!0});var c=a.render_data;a.render_data=function(e){if(this._mode==b)a.grid._fill_grid_tab(d);
else return c.apply(this,arguments)};var e=a.render_view_data;a.render_view_data=function(){if(this._mode==b)a.grid._gridScrollTop=a._els.dhx_cal_data[0].childNodes[0].scrollTop,a._els.dhx_cal_data[0].childNodes[0].scrollTop=0;a._els.dhx_cal_data[0].style.overflowY="auto";return e.apply(this,arguments)}});a[b+"_view"]=function(c){c?(a._min_date=a[d].paging?a.date[b+"_start"](new Date(a._date)):a.config[b+"_start"],a._max_date=a[d].paging?a.date.add(a._min_date,1,b):a.config[b+"_end"],a.grid.set_full_view(d),
a._els.dhx_cal_date[0].innerHTML=a._min_date>new Date(0)&&a._max_date<new Date(9999,1,1)?a.templates[b+"_date"](a._min_date,a._max_date):"",a.grid._fill_grid_tab(d),a._gridView=d):(a.grid._sort_marker=null,delete a._gridView,a._rendered=[],a[d]._selected_divs=[])}};a.dblclick_dhx_grid_area=function(){!this.config.readonly&&this.config.dblclick_create&&this.addEventNow()};if(a._click.dhx_cal_header)a._old_header_click=a._click.dhx_cal_header;a._click.dhx_cal_header=function(c){if(a._gridView){var e=
c||window.event,b=a.grid.get_sort_params(e,a._gridView);a.grid.draw_sort_marker(e.originalTarget||e.srcElement,b.dir);a.clear_view();a.grid._fill_grid_tab(a._gridView,b)}else if(a._old_header_click)return a._old_header_click.apply(this,arguments)};a.grid.selectEvent=function(c,e,b){if(a.callEvent("onBeforeRowSelect",[c,b])){var d=a.grid._getObjName(e);a.for_rendered(c,function(b){b.className+=" dhx_grid_event_selected";a[d]._selected_divs.push(b)});a._select_id=c}};a.grid._unselectDiv=function(a){a.className=
a.className.replace(/ dhx_grid_event_selected/,"")};a.grid.unselectEvent=function(c,e){var b=a.grid._getObjName(e);if(b&&a[b]._selected_divs)if(c)for(d=0;d<a[b]._selected_divs.length;d++){if(a[b]._selected_divs[d].getAttribute("event_id")==c){a.grid._unselectDiv(a[b]._selected_divs[d]);a[b]._selected_divs.slice(d,1);break}}else{for(var d=0;d<a[b]._selected_divs.length;d++)a.grid._unselectDiv(a[b]._selected_divs[d]);a[b]._selected_divs=[]}};a.grid.get_sort_params=function(c,e){var b=c.originalTarget||
c.srcElement;if(b.className=="dhx_grid_view_sort")b=b.parentNode;for(var d=!b.className||b.className.indexOf("dhx_grid_sort_asc")==-1?"asc":"desc",f=0,g=0;g<b.parentNode.childNodes.length;g++)if(b.parentNode.childNodes[g]==b){f=g;break}var j=null;if(a[e].columns[f].template)var h=a[e].columns[f].template,j=function(a){return h(a.start_date,a.end_date,a)};else{var l=a[e].columns[f].id;l=="date"&&(l="start_date");j=function(a){return a[l]}}var i=a[e].columns[f].sort;typeof i!="function"&&(i=a.grid.sort_rules[i]||
a.grid.sort_rules.str);return{dir:d,value:j,rule:i}};a.grid.draw_sort_marker=function(c,e){if(c.className=="dhx_grid_view_sort")c=c.parentNode;if(a.grid._sort_marker)a.grid._sort_marker.className=a.grid._sort_marker.className.replace(/( )?dhx_grid_sort_(asc|desc)/,""),a.grid._sort_marker.removeChild(a.grid._sort_marker.lastChild);c.className+=" dhx_grid_sort_"+e;a.grid._sort_marker=c;var b="<div class='dhx_grid_view_sort' style='left:"+(+c.style.width.replace("px","")-15+c.offsetLeft)+"px'>&nbsp;</div>";
c.innerHTML+=b};a.grid.sort_grid=function(c){var c=c||{dir:"desc",value:function(a){return a.start_date},rule:a.grid.sort_rules.date},e=a.get_visible_events();c.dir=="desc"?e.sort(function(a,d){return c.rule(a,d,c.value)}):e.sort(function(a,d){return-c.rule(a,d,c.value)});return e};a.grid.set_full_view=function(c){if(c){var e=a.locale.labels,b=a.grid._print_grid_header(c);a._els.dhx_cal_header[0].innerHTML=b;a._table_view=!0;a.set_sizes()}};a.grid._calcPadding=function(c,e){var b=(c.paddingLeft!==
void 0?1*c.paddingLeft:a[e].defPadding)+(c.paddingRight!==void 0?1*c.paddingRight:a[e].defPadding);return b};a.grid._getStyles=function(a,e){for(var b=[],d="",f=0;e[f];f++)switch(d=e[f]+":",e[f]){case "text-align":a.align&&b.push(d+a.align);break;case "vertical-align":a.valign&&b.push(d+a.valign);break;case "padding-left":a.paddingLeft!=void 0&&b.push(d+(a.paddingLeft||"0")+"px");break;case "padding-left":a.paddingRight!=void 0&&b.push(d+(a.paddingRight||"0")+"px")}return b};a.grid._fill_grid_tab=
function(c,e){for(var b=a._date,d=a.grid.sort_grid(e),f=a[c].columns,g="<div>",j=-2,h=0;h<f.length;h++){var l=a.grid._calcPadding(f[h],c);j+=f[h].width+l;h<f.length-1&&(g+="<div class='dhx_grid_v_border' style='left:"+j+"px'></div>")}g+="</div>";g+="<div class='dhx_grid_area'><table>";for(h=0;h<d.length;h++)g+=a.grid._print_event_row(d[h],c);g+="</table></div>";a._els.dhx_cal_data[0].innerHTML=g;a._els.dhx_cal_data[0].scrollTop=a.grid._gridScrollTop||0;var i=a._els.dhx_cal_data[0].getElementsByTagName("tr");
a._rendered=[];for(h=0;h<i.length;h++)a._rendered[h]=i[h]};a.grid._print_event_row=function(c,e){var b=[];c.color&&b.push("background:"+c.color);c.textColor&&b.push("color:"+c.textColor);c._text_style&&b.push(c._text_style);a[e].rowHeight&&b.push("height:"+a[e].rowHeight+"px");var d="";b.length&&(d="style='"+b.join(";")+"'");for(var f=a[e].columns,g=a.templates.event_class(c.start_date,c.end_date,c),j="<tr class='dhx_grid_event"+(g?" "+g:"")+"' event_id='"+c.id+"' "+d+">",h=a.grid._getViewName(e),
l=["text-align","vertical-align","padding-left","padding-right"],i=0;i<f.length;i++){var k;k=f[i].template?f[i].template(c.start_date,c.end_date,c):f[i].id=="date"?a.templates[h+"_full_date"](c.start_date,c.end_date,c):f[i].id=="start_date"||f[i].id=="end_date"?a.templates[h+"_single_date"](c[f[i].id]):a.templates[h+"_field"](f[i].id,c);var m=a.grid._getStyles(f[i],l),n=f[i].css?' class="'+f[i].css+'"':"";j+="<td style='width:"+f[i].width+"px;"+m.join(";")+"' "+n+">"+k+"</td>"}j+="<td class='dhx_grid_dummy'></td></tr>";
return j};a.grid._print_grid_header=function(c){for(var e="<div class='dhx_grid_line'>",b=a[c].columns,d=[],f=b.length,g=a._obj.clientWidth-2*b.length-20,j=0;j<b.length;j++){var h=b[j].initialWidth*1;!isNaN(h)&&b[j].initialWidth!=""&&b[j].initialWidth!=null&&typeof b[j].initialWidth!="boolean"?(f--,g-=h,d[j]=h):d[j]=null}for(var l=Math.floor(g/f),i=["text-align","padding-left","padding-right"],k=0;k<b.length;k++){var m=!d[k]?l:d[k];b[k].width=m-a.grid._calcPadding(b[k],c);var n=a.grid._getStyles(b[k],
i);e+="<div style='width:"+(b[k].width-1)+"px;"+n.join(";")+"'>"+(b[k].label===void 0?b[k].id:b[k].label)+"</div>"}e+="</div>";return e}});
