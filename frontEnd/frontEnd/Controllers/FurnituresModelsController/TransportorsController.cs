using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Model.FurnituresModels;
using frontEnd.Data;
using Service.FurnituresModelsService;

namespace frontEnd.Controllers.FurnituresModelsController
{
    public class TransportorsController : Controller
    {
        private Context db = new Context();
        TransporterService transportorService = new TransporterService();

        // GET: Transportors
        public ActionResult Index()
        {
            return View(transportorService.GetAll());
        }

        // GET: Transportors/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transportor transportor = transportorService.getTransportorById(id);
            if (transportor == null)
            {
                return HttpNotFound();
            }
            return View(transportor);
        }

        // GET: Transportors/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Transportors/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "TransportorId,Firstname,Lastname,Dateofbirth,Phone_number,Secteur")] Transportor transportor)
        {
            if (ModelState.IsValid)
            {
                transportorService.Add(transportor);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(transportor);
        }

        // GET: Transportors/Edit/5
        public ActionResult Edit(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transportor transportor = transportorService.getTransportorById(id);
            if (transportor == null)
            {
                return HttpNotFound();
            }
            return View(transportor);
        }

        // POST: Transportors/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, [Bind(Include = "TransportorId,Firstname,Lastname,Dateofbirth,Phone_number,Secteur")] Transportor transportor)
        {
            if (ModelState.IsValid)
            {
                transportorService.Update(id, transportor);
                return RedirectToAction("Index");
            }
            return View(transportor);
        }

        // GET: Transportors/Delete/5
        public ActionResult Delete(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transportor transportor = transportorService.getTransportorById(id);
            if (transportor == null)
            {
                return HttpNotFound();
            }
            return View(transportor);
        }

        // POST: Transportors/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Transportor transportor = transportorService.getTransportorById(id);
            transportorService.deleteTransportorById(id);
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
