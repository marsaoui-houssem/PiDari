using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FurnituresProject.Models.FurnituesModels
{
    public class Furniture
    {
        public long FurnitureId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public float Price { get; set; }
        public int Stock { get; set; }
        public float Weight { get; set; }
        public float Width { get; set; }
        public float Height { get; set; }

        // foreign Key properties

        public long? CategoryId { get; set; }

        public virtual Category MyCategory { get; set; }
    }
}