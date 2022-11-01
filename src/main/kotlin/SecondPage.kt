import java.io.File

fun SecondPage(students: List<Student>): Unit {
	val file = File("second_page.html")
	DOCTYPE(file)
	HTML(file) {
		HEAD(file) {
			STYLE(file, _text =
			"""
			table, th, td {border: 2px dashed black;}
			td {background-color: pink;}
			""".trimMargin()
			)
		}
		BODY(file) {
			A(file, "front_page.html") {
				P(file, _text = "To front page", _style = "color: blue;")
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

				for (stud in students.reversed()) {
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
			} // TABLE
		} // BODY
	} // HTML
}
