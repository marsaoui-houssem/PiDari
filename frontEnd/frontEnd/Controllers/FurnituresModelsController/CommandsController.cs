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
    public class CommandsController : Controller
    {
        private Context db = new Context();
        CommandService commadService = new CommandService();
        TransporterService transporterService = new TransporterService();

        // GET: Commands
        public ActionResult Index()
        {
            
            return View(commadService.GetAll());
        }

        // GET: Commands/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Command command = commadService.getCommandById(id);
            if (command == null)
            {
                return HttpNotFound();
            }
            return View(command);
        }

        // GET: Commands/Create
        public ActionResult Create()
        {
            ViewBag.TransportorId = new SelectList(transporterService.GetAll(), "TransportorId", "Firstname");
            return View();
        }

        // POST: Commands/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "CommandId,Etat,Date,Total_price,TransporterValidation,Code,TransportorId,UserId")] Command command)
        {
            if (ModelState.IsValid)
            {
                ViewBag.TransportorId = new SelectList(transporterService.GetAll(), "TransportorId", "Firstname");
                commadService.Add(command);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(command);
        }

        // GET: Commands/Edit/5
        public ActionResult Edit(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Command command = commadService.getCommandById(id);
            ViewBag.TransportorId = new SelectList(transporterService.GetAll(), "TransportorId", "Firstname");
            if (command == null)
            {
                return HttpNotFound();
            }
            return View(command);
        }

        // POST: Commands/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, [Bind(Include = "CommandId,Etat,Date,Total_price,TransporterValidation,Code,TransportorId,UserId")] Command command)
        {
            if (ModelState.IsValid)
            {
                commadService.Update(id, command);
                return RedirectToAction("Index");
            }
            return View(command);
        }

        // GET: Commands/Delete/5
        public ActionResult Delete(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Command command = commadService.getCommandById(id);
            if (command == null)
            {
                return HttpNotFound();
            }
            return View(command);
        }

        // POST: Commands/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Command command = commadService.getCommandById(id);
            commadService.deleteCommandById(id);
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
