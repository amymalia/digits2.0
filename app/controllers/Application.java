package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;
import play.data.Form;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }

  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The NewContact.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));

  }

  /**
   * Processes form submitted from newContact page
   * @return Result of the New Contact page
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    ContactFormData data = formData.get();
    System.out.println("OK: " + data.firstName + " " + data.lastName + " " + data.telephone);
    return ok(NewContact.render(formData));
  }

}
