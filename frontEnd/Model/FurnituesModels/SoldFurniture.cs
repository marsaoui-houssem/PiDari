using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FurnituresProject.Models.FurnituesModels
{
    public class SoldFurniture
    {
        public long SoldfurnitureId { get; set; }
        public float Price { get; set; }
        public string Name { get; set; }
        public int Quantity { get; set; }


        // foreign Key properties

        public long? CommandId { get; set; }
        public virtual Command MyCommand { get; set; }
    }
}