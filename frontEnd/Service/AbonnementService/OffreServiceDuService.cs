using Model.Abonnement;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Service.AbonnementService
{
   public  class OffreServiceDuService
    {
        HttpClient httpClient;


        public OffreServiceDuService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
           // httpClient.DefaultRequestHeaders.Add("Authorization", String.Format("Bearer{0}", Statics._AccessToken));
        }




        public Boolean ajouterService(OffreService of)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<OffreService>(Statics.baseAddress + "ServiceDari/ajouterService",of).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }



        public IEnumerable<OffreService> getAllServ()
        {

            var response = httpClient.GetAsync(Statics.baseAddress + "ServiceDari/getAllServ").Result;
            if (response.IsSuccessStatusCode)
            {
                var OffreService = response.Content.ReadAsAsync<IEnumerable<OffreService>>().Result;
                return OffreService;
            }
            return new List<OffreService>();


        }

        public OffreService  getByIdService(int id)
        {
            OffreService offreService = null;
            var response = httpClient.GetAsync(Statics.baseAddress + "ServiceDari/getServById/" + id).Result;

            if (response.IsSuccessStatusCode)
            {
                var e = response.Content.ReadAsAsync<OffreService>().Result;
                return e;
            }
            return offreService;
        }



        public bool deleteService(int id)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "ServiceDari/deleteServ/" + id);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public bool affecteServiceAabonn( int idServ , int idAbon)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<OffreService>(Statics.baseAddress + "ServiceDari/affServAbonn/"+idServ+"/"+ idAbon,
                 null).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());

                System.Diagnostics.Debug.WriteLine(APIResponse.Result);

                return true;
            }
            catch
            {
                return false;
            }
        }


        public float prixServiceMenagemen(int idServ ,int idAd)
        {

            float prixM = 0;

            var response = httpClient.GetAsync(Statics.baseAddress + "ServiceDari/prixServiceMenegement/" + idServ + "/" + idAd).Result;

            if (response.IsSuccessStatusCode)
            {
                var prix = response.Content.ReadAsAsync<float>().Result;
                return prix;
            }


            return prixM;


        }


        public bool mettreAjourPrixService(int idServ , int idAd )
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<OffreService>(Statics.baseAddress + "Assurence/mettreAjourPrixService/" + idServ + "/" + idAd,null).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);

                return true;
            }
            catch
            {
                return false;
            }



        }







    }
}
