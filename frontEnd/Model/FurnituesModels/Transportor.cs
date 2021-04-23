using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FurnituresProject.Models.FurnituesModels
{
    public class Transportor
    {
        public long TransportorId { get; set; }
        public string Firstname { get; set; }
        public string Lastname { get; set; }
        public DateTime Dateofbirth { get; set; }
        public int Phone_number { get; set; }
        public string Secteur { get; set; }
    }
}