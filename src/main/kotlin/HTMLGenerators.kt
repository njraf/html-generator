import java.io.File

private var indent = 0

fun DOCTYPE(_file: File) = _file.writeText("<!DOCTYPE html>\n")

fun HTML(_file: File, _content: () -> Unit): Unit {
	_file.appendText("<html>\n")
	indent++
	_content()
	indent--
	_file.appendText("\n</html>\n")
}

fun BODY(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<body" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</body>")
}

///// HEAD /////

fun HEAD(_file: File, _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<head>\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</head>\n")
}

fun STYLE(_file: File, _text: String): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<style>\n")
	indent++
	_file.appendText("$_text\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</style>\n")
}

fun LINK(_file: File, _rel: String, _href: String): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<link rel=\"$_rel\" href=\"$_href\">\n")
}

fun TITLE(_file: File, _title: String = "", _id: String = "", _class: String = "", _style: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<title" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">$_title</title>\n")
}

fun SCRIPT(_file: File, _text: String = "", _src: String = "", _type: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<script" +
			(if (_src.isNotBlank()) " src=\"$_src\"" else "") +
			(if (_type.isNotBlank()) " type=\"$_type\"" else "") +
			">")
	if (_text.isNotBlank()) {
		//indent++
		_file.appendText("\n$_text\n")
		//indent--
		for (i in 0 until indent) _file.appendText("\t")
	}
	_file.appendText("</script>\n")
}

fun BASE(_file: File, _href: String, _target: String): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<base href=\"$_href\" target=\"$_target\">\n")
}

///// BASICS /////

fun DIV(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<div" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</div>\n")
}

fun P(_file: File, _text: String = "", _id: String = "", _class: String = "", _style: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<p" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">$_text</p>\n")
}

fun A(_file: File, _href: String, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<a href=\"${_href}\"" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</a>\n")
}

///// TABLE /////

fun TABLE(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<table" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</table>\n")
}

fun TR(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<tr" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</tr>\n")
}

fun TH(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<th" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</th>\n")
}

fun TD(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<td" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</td>\n")
}

///// LISTS /////

fun UL(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<ul" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</ul>\n")
}

fun OL(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<ol" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</ol>\n")
}

fun LI(_file: File, _text: String, _id: String = "", _class: String = "", _style: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<li" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">")
	_file.appendText(_text)
	_file.appendText("</li>\n")
}

fun DL(_file: File, _id: String = "", _class: String = "", _style: String = "", _content: () -> Unit): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<dl" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">\n")
	indent++
	_content()
	_file.appendText("\n")
	indent--
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("</dl>\n")
}

fun DT(_file: File, _text: String, _id: String = "", _class: String = "", _style: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<dt" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">")
	_file.appendText("$_text</dt>\n")
}

fun DD(_file: File, _text: String, _id: String = "", _class: String = "", _style: String = ""): Unit {
	for (i in 0 until indent) _file.appendText("\t")
	_file.appendText("<dd" +
			(if (_id.isNotBlank()) " id=\"$_id\"" else "") +
			(if (_class.isNotBlank()) " class=\"$_class\"" else "") +
			(if (_style.isNotBlank()) " style=\"$_style\"" else "") +
			">")
	_file.appendText("$_text</dd>\n")
}