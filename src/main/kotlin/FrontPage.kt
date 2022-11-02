import java.io.File

fun FrontPage(students: List<Student>): Unit {
	val file = File("front_page.html")
	DOCTYPE(file)
	HTML(file) {
		HEAD(file) {
			TITLE(file, "Front Page")
			STYLE(file, _text =
			"""
			table, th, td {border: 2px solid black;}
			td {background-color: cyan;}
			#tableHeader {background-color: yellow;}
			.firstColumn {background-color: lightgreen;}
			""".trimMargin()
			)
		}
		BODY(file) {
			A(file, "second_page.html") {
				P(file, _text = "To second page", _style = "color: red;")
			}

			TABLE(file) {
				TR(file, _id = "tableHeader") {
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
						TD(file, _class = "firstColumn") {
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

			UL(file) {
				LI(file, "First Item")
				LI(file, "Second Item")
			}
		} // BODY
	} // HTML
}
