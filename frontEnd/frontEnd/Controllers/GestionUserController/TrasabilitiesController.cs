using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Model.GestionUser;
using frontEnd.Data;
using System.Net.Http;
using System.Net.Http.Headers;

namespace frontEnd.Controllers.GestionUserController
{
    public class TrasabilitiesController : Controller
    {
        public ActionResult Index()
        {
            IEnumerable<Trasability> tra = null;
            using (var client = new HttpClient())
            {
                //var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                //client.DefaultRequestHeaders.Authorization = newhttp://localhost:8085/dari/ AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var responseTask = client.GetAsync("trasability/all");
                responseTask.Wait();
                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readJob = result.Content.ReadAsAsync<IList<Trasability>>();
                    readJob.Wait();
                    tra = readJob.Result;
                }
                else
                {
                    //return the error
                    tra = Enumerable.Empty<Trasability>();
                    ModelState.AddModelError(String.Empty, "error");
                }

            }
            return View(tra);

     
        }

        public ActionResult Details()
        {
            using (var client = new HttpClient())
            {
                //var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                //client.DefaultRequestHeaders.Authorization = newhttp://localhost:8085/dari/ AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                var _AccessToken = System.Web.HttpContext.Current.Session["access_token"];
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", (string)_AccessToken);
                client.BaseAddress = new Uri("http://localhost:8085/dari/");
                var responseTask = client.GetAsync("makecall/");
                responseTask.Wait();
                var result = responseTask.Result;
            }

            return View();
        }


    }


}
