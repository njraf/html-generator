import java.io.File

fun makePage(file: File, students: List<Student>): Unit {
	HTML(file) {
		HEAD(file) {
			STYLE(file, text =
				"""
					table, th, td {border: 2px solid black;}
					td {background-color: cyan;}
				""".trimMargin()
			)
		}
		BODY(file) {
			A(file, "https://old.reddit.com") {
				P(file, text = "To Reddit", style = "color: red;")
			}
			TABLE(file) {
				TR(file) {
					TH(file) {
						P(file, "First Name")
					}
					TH(file) {
						P(file, "Last Name")
					}
					TH(file) {
						P(file, "GPA")
					}
					TH(file) {
						P(file, "Age")
					}
				}

				for (stud in students) {
					TR(file) {
						TD(file) {
							P(file, stud.firstName)
						}
						TD(file) {
							P(file, stud.lastName)
						}
						TD(file) {
							P(file, stud.gpa.toString())
						}
						TD(file) {
							P(file, stud.age.toString())
						}
					}
				}
			}
		}
	}
}

fun main() {
	val students = listOf<Student>(
		Student("Nick", "Rafala", 3.5, 16),
		Student("Jack", "Black", 2.3, 13),
		Student("Fred", "Flintstone", 2.7, 11),
		Student("James", "Cameron", 3.8, 15)
	)

	val file = File("output.html")
	makePage(file, students)

}

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