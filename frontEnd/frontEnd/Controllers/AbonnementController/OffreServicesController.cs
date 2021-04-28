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

namespace frontEnd.Controllers.AbonnementController
{
    public class OffreServicesController : Controller
    {
        private Context db = new Context();

        OffreServiceDuService offreServiceDuService = new OffreServiceDuService();

        // GET: OffreServices
        public ActionResult Index()
        {
            return View(offreServiceDuService.getAllServ());
        }

        // GET: OffreServices/Details/5
        public ActionResult Details(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OffreService offreService = offreServiceDuService.getByIdService(id);
            if (offreService == null)
            {
                return HttpNotFound();
            }
            return View(offreService);
        }

        // GET: OffreServices/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: OffreServices/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idServ,nomServ,descSer,dureService,prixServ,datedebutService,dateFintService,TypeService")] OffreService offreService)
        {
            if (ModelState.IsValid)
            {
                offreServiceDuService.ajouterService(offreService);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(offreService);
        }

        // GET: OffreServices/Edit/5
        public ActionResult Edit(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OffreService offreService = offreServiceDuService.getByIdService(id);
            if (offreService == null)
            {
                return HttpNotFound();
            }
            return View(offreService);
        }

        // POST: OffreServices/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idServ,nomServ,descSer,dureService,prixServ,datedebutService,dateFintService,TypeService")] OffreService offreService)
        {
            if (ModelState.IsValid)
            {
                offreServiceDuService.ajouterService(offreService);
                return RedirectToAction("Index");
            }
            return View(offreService);
        }

        // GET: OffreServices/Delete/5
        public ActionResult Delete(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OffreService offreService = offreServiceDuService.getByIdService(id);
            if (offreService == null)
            {
                return HttpNotFound();
            }
            return View(offreService);
        }

        // POST: OffreServices/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            offreServiceDuService.deleteService(id);
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
    }
}
