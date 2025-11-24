combobox$mold$= function (out) {
	var uuid = this.uuid,
	isButtonVisible = this._buttonVisible;

	out.push('<span', this.domAttrs_({text: true, tabindex: true}), '>');
	if (null != this.label)
		out.push('<div id="',uuid,'-div"><table id="',uuid,'-table" style="border-spacing:0px"><tbody id="',uuid,'-tbody"><tr id="',uuid,'-tr"><td id="',uuid,'-td1"><div class="field">');
	out.push('<input id="', uuid, '-real" ');
	out.push(' autocomplete="off" ');	
	if (null != this.label)
		out.push(' class="field" ');
	else
		out.push(' class="z-textbox" ');
	out.push(this.textAttrs_());
	if (null != this.label)
		out.push(' placeholder="." ');
	out.push('/>');
	if (null != this.label)
		out.push('<label class="field" id="',uuid, '-real-label" for="',uuid,'-real">',this.label,'</label></div></td><td id="',uuid,'-td2">');
	out.push('<a id="', uuid, '-btn" class="', this.$s('button'));

	if (!isButtonVisible)
		out.push(' ', this.$s('disabled'));

	if (null != this.label)
		out.push('style="border:0px"') 
	out.push(' " >');
	out.push('<i id="', uuid, '-icon" class="z-combobox-icon z-icon-calendar" ></i></a>');

	this.redrawpp_(out);

	if (null != this.label)
		out.push('</td></tr></tbody></table><div></span>');
};
