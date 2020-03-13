package messagesStudy;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;

public class HttpRequests {

//	This is what they see in the question for SpotBugs condition.
	public void actionA(HttpServletRequest req, HttpServletResponse resp) {

		try {
			OutputStream out = resp.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

//	This is what they see in the question for SonarQube condition.
	public void actionB(HttpServletRequest req, HttpServletResponse resp) {

		try {
			OutputStream out = resp.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	May expose sensitive information to public.
	public void bad_answer_1(HttpServletRequest req, HttpServletResponse resp) {

		try {
			OutputStream out = resp.getOutputStream();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			System.out.println(e.toString());
		}
	}

//	May expose sensitive information to public.
	public void bad_answer_2(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

		try {
			OutputStream out = resp.getOutputStream();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	Only shows a generic error and doesn't expose sensitive information to public.
	public void action_right_answer(HttpServletRequest req, HttpServletResponse resp) {

		try {
			OutputStream out = resp.getOutputStream();
			System.out.print("Here is the results: " + out);
		} catch (Exception e) {
			System.out.print("An error occured!");
		}
	}

}
