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
    public class AssurencesController : Controller
    {
        private Context db = new Context();

        AssurenceService assurenceService = new AssurenceService();

        // GET: Assurences
        public ActionResult Index()
        {
            return View(assurenceService.getAllAssurence());
        }

        // GET: Assurences/Details/5
        public ActionResult Details(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Assurence assurence = assurenceService.getByIdAssurence(id);
            if (assurence == null)
            {
                return HttpNotFound();
            }
            return View(assurence);
        }

        // GET: Assurences/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Assurences/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "idAssu,nomAssu,descAssu,dureAss,dateDeburAssu,dateFintAssu,prixAss,TypeAssurence")] Assurence assurence)
        {
            if (ModelState.IsValid)
            {
                assurenceService.ajoutAssurence(assurence);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(assurence);
        }

        // GET: Assurences/Edit/5
        public ActionResult Edit(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Assurence assurence = assurenceService.getByIdAssurence(id) ;
            if (assurence == null)
            {
                return HttpNotFound();
            }
            return View(assurence);
        }

        // POST: Assurences/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "idAssu,nomAssu,descAssu,dureAss,dateDeburAssu,dateFintAssu,prixAss,TypeAssurence")] Assurence assurence)
        {
            if (ModelState.IsValid)
            {
                assurenceService.ajoutAssurence(assurence);
                return RedirectToAction("Index");
            }
            return View(assurence);
        }

        // GET: Assurences/Delete/5
        public ActionResult Delete(int id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Assurence assurence = assurenceService.getByIdAssurence(id);
            if (assurence == null)
            {
                return HttpNotFound();
            }
            return View(assurence);
        }

        // POST: Assurences/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            assurenceService.deleteAssurence(id); 
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
