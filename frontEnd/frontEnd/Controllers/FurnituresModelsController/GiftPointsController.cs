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
    public class GiftPointsController : Controller
    {
        private Context db = new Context();
        GiftPointsService giftPointsService = new GiftPointsService();

        // GET: GiftPoints
        public ActionResult Index()
        {
            
            return View(giftPointsService.GetAll());
        }

        // GET: GiftPoints/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            GiftPoints giftPoints = giftPointsService.getGiftPointsById(id);
            if (giftPoints == null)
            {
                return HttpNotFound();
            }
            return View(giftPoints);
        }

        // GET: GiftPoints/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: GiftPoints/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "GiftpointsId,Points,Etat,Code,Begin_date,End_date,Value,UserId")] GiftPoints giftPoints)
        {
            if (ModelState.IsValid)
            {
                giftPointsService.Add(giftPoints);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(giftPoints);
        }

        // GET: GiftPoints/Edit/5
        public ActionResult Edit(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            GiftPoints giftPoints = giftPointsService.getGiftPointsById(id);
            if (giftPoints == null)
            {
                return HttpNotFound();
            }
            return View(giftPoints);
        }

        // POST: GiftPoints/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, [Bind(Include = "GiftpointsId,Points,Etat,Code,Begin_date,End_date,Value,UserId")] GiftPoints giftPoints)
        {
            if (ModelState.IsValid)
            {
                giftPointsService.Update(id, giftPoints);
                return RedirectToAction("Index");
            }
            return View(giftPoints);
        }

        // GET: GiftPoints/Delete/5
        public ActionResult Delete(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            GiftPoints giftPoints = giftPointsService.getGiftPointsById(id);
            if (giftPoints == null)
            {
                return HttpNotFound();
            }
            return View(giftPoints);
        }

        // POST: GiftPoints/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            GiftPoints giftPoints = giftPointsService.getGiftPointsById(id);
            giftPointsService.deleteGiftPointsById(id);
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
