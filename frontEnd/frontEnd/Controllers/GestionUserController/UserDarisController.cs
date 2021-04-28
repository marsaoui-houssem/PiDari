using System;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using Model.GestionUser;
using frontEnd.Data;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Service;
using System.Collections.Generic;

namespace frontEnd.Controllers.GestionUserController
{
    public class UserDarisController : Controller
    {



        UserService userservice = new UserService();

        private Context db = new Context();


        public ActionResult Index()
        {
            IEnumerable<UserDari> user = null;
            using (var client = new HttpClient())
            {
                //var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                //client.DefaultRequestHeaders.Authorization = newhttp://localhost:8085/dari/ AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var responseTask = client.GetAsync("user/getAllUsers/");
                responseTask.Wait();
                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readJob = result.Content.ReadAsAsync<IList<UserDari>>();
                    readJob.Wait();
                    user = readJob.Result;
                }
                else
                {
                    //return the error
                    user = Enumerable.Empty<UserDari>();
                    ModelState.AddModelError(String.Empty, "error");
                }

            }
            return View(user);

        }
   // GET: Banks/Details/5
        public ActionResult Details(long id)
        {
            UserDari user = null;
            using (var client = new HttpClient())
            {
                //var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                //client.DefaultRequestHeaders.Authorization = newhttp://localhost:8085/dari/ AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var responseTask = client.GetAsync("user/getbyId/" + id);
                responseTask.Wait();
                var result = responseTask.Result;

                
                if (result.IsSuccessStatusCode)

                {
                    var readJob = result.Content.ReadAsAsync<UserDari>();
                    readJob.Wait();

                    user = readJob.Result;
                }
            }
           
            return View(user);
        }


        public ActionResult Login1()


        {


            return View();
        }

        public ActionResult Login()


        {


            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Login(Tokken tkn)  //JwtRequest model 3emluo ena maoujoud e5er lfichier


        {
            using (var httpClient = new HttpClient())
            {
                httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                StringContent stringContent = new StringContent(JsonConvert.SerializeObject(tkn), System.Text.Encoding.UTF8, "application/json");

                using (HttpResponseMessage response1 = await httpClient.PostAsync("http://localhost:8085/dari/login", stringContent))
                {

                    String myTok = await response1.Content.ReadAsStringAsync();

                    if (myTok == "Invalid credentials")
                    {
                        ViewBag.mssg = "incorrct usr";
                    }

                    HttpContext.Session.Add("access_token", myTok); //storit etoken fe session
                    var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];//oki


                    ViewBag.bareer = stringContent;
                    ViewBag.bareerConsumedResps = stringContent;

                    ViewBag.bareerConsumed = myTok;
                    ViewBag.bareeSession = _AccessToken;
                }
            }

            return View();
        }



        // GET: UserDaris/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: UserDaris/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(UserDari userDari)
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8085/dari/user/register");
                var postJob = client.PostAsJsonAsync<UserDari>("register", userDari);
                postJob.Wait();
                // return View();
                var postResult = postJob.Result;
                DateTime dateCreation = DateTime.Now;

                if (postResult.IsSuccessStatusCode)

                    return RedirectToAction("Home");
            }
            //ModelState.AddModelError(string.Empty, "Server occured errors. Please check with admin!");
            return View(userDari);
        }

        // GET: UserDaris/Edit/5
        public ActionResult Edit(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UserDari userDari = db.UserDaris.Find(id);
            if (userDari == null)
            {
                return HttpNotFound();
            }
            return View(userDari);
        }

        // POST: UserDaris/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "userId,FirstName,LastName,Email,Password,PhoneNumber,Activated,ImageUrl")] UserDari userDari)
        {
            if (ModelState.IsValid)
            {
                db.Entry(userDari).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(userDari);
        }

        // GET: UserDaris/Delete/5
        public ActionResult Delete(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            UserDari userDari = db.UserDaris.Find(id);
            if (userDari == null)
            {
                return HttpNotFound();
            }
            return View(userDari);
        }

        // POST: UserDaris/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            UserDari user = null;
            using (var client = new HttpClient())
            {
                //var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                //client.DefaultRequestHeaders.Authorization = newhttp://localhost:8085/dari/ AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var responseTask = client.GetAsync("user/getbyId/" + id);
                responseTask.Wait();
                var result = responseTask.Result;


                if (result.IsSuccessStatusCode)

                {
                    var readJob = result.Content.ReadAsAsync<UserDari>();
                    readJob.Wait();

                    user = readJob.Result;
                }

                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var deleateTask = client.DeleteAsync("user/getbyId/" + id).Result;
                responseTask.Wait();
            }
            return View();
            }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
