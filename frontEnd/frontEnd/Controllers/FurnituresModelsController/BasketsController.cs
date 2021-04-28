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
using Service;

namespace frontEnd.Controllers.FurnituresModelsController
{
    public class BasketsController : Controller
    {
        private Context db = new Context();
        FurnitureService furnitureService = new FurnitureService();
        BasketService basketService = new BasketService();
        UserService userService = new UserService();

        // GET: Baskets
        public ActionResult Index()
        {
            return View(basketService.GetAll());
        }

        // GET: Baskets/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Basket basket = basketService.getBasketById(id);
            if (basket == null)
            {
                return HttpNotFound();
            }
            return View(basket);
        }

        // GET: Baskets/Create
        public ActionResult Create()
        {
            ViewBag.FurnitureId = new SelectList(furnitureService.GetAll(), "furnitureId", "name" ,"price") ;
            return View();
        }

        // POST: Baskets/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "BasketId,Quantity,FurnitureId,UserId")] Basket basket)
        {
            if (ModelState.IsValid)
            {
                ViewBag.FurnitureId = new SelectList(furnitureService.GetAll(), "furnitureId", "name", "price");
                basketService.Add(2,1,2);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(basket);
        }

        // GET: Baskets/Edit/5
        public ActionResult Edit(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Basket basket = basketService.getBasketById(id);
            ViewBag.FurnitureId = new SelectList(furnitureService.GetAll(), "furnitureId", "name", "price");
            if (basket == null)
            {
                return HttpNotFound();
            }
            return View(basket);
        }

        // POST: Baskets/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(long id, [Bind(Include = "BasketId,Quantity,FurnitureId,UserId")] Basket basket)
        {
            if (ModelState.IsValid)
            {
                basketService.Update(id, basket);
                return RedirectToAction("Index");
            }
            return View(basket);
        }

        // GET: Baskets/Delete/5
        public ActionResult Delete(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Basket basket = basketService.getBasketById(id);
            if (basket == null)
            {
                return HttpNotFound();
            }
            return View(basket);
        }

        // POST: Baskets/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Basket basket = basketService.getBasketById(id);
            basketService.deleteBasketById(id);

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
