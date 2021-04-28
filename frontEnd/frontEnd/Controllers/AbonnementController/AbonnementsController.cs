using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Model.Abonnement;
using frontEnd.Data;
using Service.AbonnementService;
using System.Net.Http;
using System.Net.Http.Headers;

namespace frontEnd.Controllers.AbonnementController
{
    public class AbonnementsController : Controller
    {
        private Context db = new Context();
        AbonnementService abonnementService = new AbonnementService();


       
        // GET: Abonnements
        public ActionResult Index()
        {
           
            return View(abonnementService.getAllAbon());

        }

        // GET: Abonnements/Details/5
        public ActionResult Details(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Abonnement abonnement = abonnementService.getAbonnById(id);
            if (abonnement == null)
            {
                return HttpNotFound();
            }
            return View(abonnement);
        }

        // GET: Abonnements/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Abonnements/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idAbon,nomAbon,descriptionAbon,typeAbon,dureAbonn,dateDebut,datefint,prix")] Abonnement abonnement)
        {
            if (ModelState.IsValid)
            {
                abonnementService.ajoutAbonn(abonnement);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(abonnement);
        }

        // GET: Abonnements/Edit/5
        public ActionResult Edit(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Abonnement abonnement = abonnementService.getAbonnById(id);
            if (abonnement == null)
            {
                return HttpNotFound();
            }
            return View(abonnement);

        }

        // POST: Abonnements/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idAbon,nomAbon,descriptionAbon,typeAbon,dureAbonn,dateDebut,datefint,prix")] Abonnement abonnement)
        {

         
            if (ModelState.IsValid)
            {
                abonnementService.ajoutAbonn(abonnement);
                return RedirectToAction("Index");
            }
            return View(abonnement);


        }

        // GET: Abonnements/Delete/5
        public ActionResult Delete(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Abonnement abonnement = abonnementService.getAbonnById(id);
            if (abonnement == null)
            {
                return HttpNotFound();
            }
            return View(abonnement);
        }

        // POST: Abonnements/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            abonnementService.deleteAbonn(id);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }


        public ActionResult getAllAssubyAbon(int idAbon)
        {

            return View(abonnementService.getAllAssubyAbon(idAbon));

        }

        public ActionResult getAllServbyAbon(int idAbon)
        {
            return View(abonnementService.getAllServbyAbon(idAbon));
        }







    }
}
