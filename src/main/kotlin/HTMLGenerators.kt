import java.io.File

fun HTML(file: File, content: () -> Unit): Unit {
	file.writeText("<html>\n")
	content()
	file.appendText("\n</html>\n")
}

fun BODY(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<body>\n")
	content()
	file.appendText("\n</body>")
}

fun HEAD(file: File, content: () -> Unit): Unit {
	file.appendText("<head>\n")
	content()
	file.appendText("\n</head>")
}

fun STYLE(file: File, text: String): Unit {
	file.appendText("<style>\n$text\n</style>")
}

fun P(file: File, text: String = "", style: String = ""): Unit {
	file.appendText("<p style=\"$style\">\n$text\n</p>")
}

fun DIV(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<div>\n")
	content()
	file.appendText("\n</div>")
}

fun A(file: File, href: String = "", style: String = "", content: () -> Unit): Unit {
	file.appendText("<a href=\"${href}\" style=\"$style\">\n")
	content()
	file.appendText("\n</a>")
}

fun TABLE(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<table style=\"$style\">\n")
	content()
	file.appendText("\n</table>")
}

fun TR(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<tr style=\"$style\">\n")
	content()
	file.appendText("\n</tr>")
}

fun TH(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<th style=\"$style\">\n")
	content()
	file.appendText("\n</th>")
}

fun TD(file: File, style: String = "", content: () -> Unit): Unit {
	file.appendText("<td style=\"$style\">\n")
	content()
	file.appendText("\n</td>")
}