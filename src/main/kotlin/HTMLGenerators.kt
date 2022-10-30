import java.io.File

var indent = 0

fun DOCTYPE(file: File) = file.writeText("<!DOCTYPE html>\n")

fun HTML(file: File, content: () -> Unit): Unit {
	file.appendText("<html>\n")
	indent++
	content()
	indent--
	file.appendText("\n</html>\n")
}

fun BODY(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<body>\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</body>")
}

fun HEAD(file: File, content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<head>\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</head>\n")
}

fun STYLE(file: File, text: String): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<style>\n")
	indent++
	file.appendText("$text\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</style>\n")
}

fun P(file: File, text: String = "", style: String = ""): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<p style=\"$style\">$text</p>\n")
}

fun DIV(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<div>\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</div>\n")
}

fun A(file: File, href: String = "", style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<a href=\"${href}\" style=\"$style\">\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</a>\n")
}

fun TABLE(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<table style=\"$style\">\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</table>\n")
}

fun TR(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<tr style=\"$style\">\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</tr>\n")
}

fun TH(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<th style=\"$style\">\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</th>\n")
}

fun TD(file: File, style: String = "", content: () -> Unit): Unit {
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("<td style=\"$style\">\n")
	indent++
	content()
	file.appendText("\n")
	indent--
	for (i in 0 until indent) file.appendText("\t")
	file.appendText("</td>\n")
}