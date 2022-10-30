import java.io.File

fun FrontPage(students: List<Student>): Unit {
	val file = File("front_page.html")
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
			} // TABLE
		} // BODY
	} // HTML
}
