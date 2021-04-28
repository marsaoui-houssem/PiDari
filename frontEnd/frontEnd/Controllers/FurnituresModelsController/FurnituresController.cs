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
    public class FurnituresController : Controller
    {
        private Context db = new Context();
        FurnitureService furnitureService = new FurnitureService();
        CategoryService categoryService = new CategoryService();

        // GET: Furnitures
        public ActionResult Index()
        {
            return View(furnitureService.GetAll());
        }

        // GET: Furnitures/Details/5
        public ActionResult Details(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Furniture furniture = furnitureService.getFurnitureById(id);
            if (furniture == null)
            {
                return HttpNotFound();
            }
            return View(furniture);
        }

        // GET: Furnitures/Create
        public ActionResult Create()
        {
            ViewBag.CategoryId = new SelectList(categoryService.GetAll(), "categoryId", "name", "description");
            return View();
        }

        // POST: Furnitures/Create
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Name,Description,Price,Stock,Weight,Width,Height,CategoryId")] Furniture furniture)
        {
            if (ModelState.IsValid)
            {
                ViewBag.CategoryId = new SelectList(categoryService.GetAll(), "categoryId", "name", "description");
                furniture.MyCategory = categoryService.getCategoryById(1);
                furnitureService.Add(furniture);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(furniture);
        }

        public ActionResult Create2()
        {
            ViewBag.CategoryId = new SelectList(categoryService.GetAll(), "categoryId", "name", "description");
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create2([Bind(Include = "CategoryId")] long id , [Bind(Include = "Name,Description,Price,Stock,Weight,Width,Height")] Furniture furniture)
        {
            if (ModelState.IsValid)
            {
                ViewBag.CategoryId = new SelectList(categoryService.GetAll(), "categoryId", "name", "description");
                furniture.MyCategory = categoryService.getCategoryById(id);
                furnitureService.Add(furniture);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(furniture);
        }
        // GET: Furnitures/Edit/5
        public ActionResult Edit(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Furniture furniture = furnitureService.getFurnitureById(id);
            ViewBag.CategoryId = new SelectList(categoryService.GetAll(), "categoryId", "name");
            if (furniture == null)
            {
                return HttpNotFound();
            }
            return View(furniture);
        }

        // POST: Furnitures/Edit/5
        // Afin de déjouer les attaques par survalidation, activez les propriétés spécifiques auxquelles vous voulez établir une liaison. Pour 
        // plus de détails, consultez https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id,[Bind(Include = "FurnitureId,Name,Description,Price,Stock,Weight,Width,Height,CategoryId")] Furniture furniture)
        {
            if (ModelState.IsValid)
            {
                furnitureService.Update(id, furniture);
                return RedirectToAction("Index");
            }
            return View(furniture);
        }

        // GET: Furnitures/Delete/5
        public ActionResult Delete(long id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Furniture furniture = furnitureService.getFurnitureById(id);
            if (furniture == null)
            {
                return HttpNotFound();
            }
            return View(furniture);
        }

        // POST: Furnitures/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Furniture furniture = furnitureService.getFurnitureById(id);
            furnitureService.deleteFurnitureById(id);


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
