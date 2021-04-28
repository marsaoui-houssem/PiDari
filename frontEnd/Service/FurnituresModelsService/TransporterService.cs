using Model.FurnituresModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Service.FurnituresModelsService
{
    public class TransporterService
    {
        HttpClient httpClient;
        public TransporterService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public Boolean Add(Transportor transporter)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Transportor>(Statics.baseAddress + "dari/furnitures/addFurniture", transporter).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public Transportor getTransportorById(long transportorId)
        {
            Transportor transportor = null;

            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getFurnitureById/" + transportorId).Result;

            if (response.IsSuccessStatusCode)
            {
                var b
                    = response.Content.ReadAsAsync<Transportor>().Result;

                return b;
            }


            return transportor;
        }


        public bool Update(long id, Transportor transportor)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Transportor>(Statics.baseAddress + "dari/furnitures/modifierFurniture/" + id, transportor).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public bool deleteTransportorById(long id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "dari/furnitures/deleteFurniture/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public IEnumerable<Transportor> GetAll()
        {
            var response = httpClient.GetAsync(Statics.baseAddress + "dari/furnitures/getAllCFurniture").Result;
            if (response.IsSuccessStatusCode)
            {
                var transportors = response.Content.ReadAsAsync<IEnumerable<Transportor>>().Result;
                return transportors;
            }
            return new List<Transportor>();
        }




    }
}
