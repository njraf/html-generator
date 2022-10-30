import java.io.File
import java.lang.Exception

fun makePage(students: List<Student>): String =
	HTML {
		HEAD {
			STYLE {
				"""
					table, th, td {border: 2px solid black;}
					td {background-color: cyan;}
				""".trimMargin()
			}
		} +
		BODY {
			A("https://old.reddit.com") {
				P(text = "To Reddit", style = "color: red;")
			} +
			TABLE {
				var content = TR {
					TH {
						"First Name"
					} +
					TH {
						"Last Name"
					} +
					TH {
						"GPA"
					} +
					TH {
						"Age"
					}
				}

				for (stud in students) {
					content += TR {
						TD {
							stud.firstName
						} +
						TD {
							stud.lastName
						} +
						TD {
							stud.gpa.toString()
						} +
						TD {
							stud.age.toString()
						}
					}
				}
				return@TABLE content
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
	val html = makePage(students)
	println(html)

	val file = File("output.html")
	file.writeText(html)
}

fun HTML(content: () -> String): String = "<html>${content()}</html>"

fun BODY(style: String = "", content: () -> String): String = "<body>${content()}</body>"

fun HEAD(content: () -> String): String = "<head>${content()}</head>"

fun STYLE(content: () -> String): String = "<style>${content()}</style>"

fun P(text: String = "", style: String = ""): String = "<p style=\"$style\">$text</p>"

fun DIV(style: String = "", content: () -> String): String = "<div>${content()}</div>"

fun A(href: String = "", style: String = "", content: () -> String): String = "<a href=\"${href}\" style=\"$style\">${content()}</a>"

fun TABLE(style: String = "", content: () -> String): String = "<table style=\"$style\">${content()}</table>"

fun TR(style: String = "", content: () -> String): String = "<tr style=\"$style\">${content()}</tr>"

fun TH(style: String = "", content: () -> String): String = "<th style=\"$style\">${content()}</th>"

fun TD(style: String = "", content: () -> String): String = "<td style=\"$style\">${content()}</td>"