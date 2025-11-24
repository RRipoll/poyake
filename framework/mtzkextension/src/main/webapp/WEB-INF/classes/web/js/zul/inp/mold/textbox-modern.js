function (out) {
	var uuid = this.uuid;
	// ZK-679: Textbox multi-line start with new-line failed in onCreate event
	// browser will ignore first newline
	if(this.isMultiline()) 
		out.push('<textarea', this.domAttrs_(), '>\n', this._areaText(), '</textarea>');
	else {
		if (null !=this.label)
			out.push('<div class="field">');
		out.push('<input ');
		if (null !=this.label)
			out.push(' placeholder="." class="field" ');
		out.push( this.domAttrs_());
		out.push('/>');
		if (null !=this.label)
			out.push('<label class="field" for="',uuid,'">',this.label,'</label></div>');
	}
}