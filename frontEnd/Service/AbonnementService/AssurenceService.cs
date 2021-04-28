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
   public  class AssurenceService
    {
        HttpClient httpClient;



        public AssurenceService()
        {
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(Statics.baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
          //  httpClient.DefaultRequestHeaders.Add("Authorization", String.Format("Bearer{0}", Statics._AccessToken));
        }




        public IEnumerable<Assurence> getAllAssurence()
        {

            var response = httpClient.GetAsync(Statics.baseAddress + "Assurence/getAllassu").Result;
            if (response.IsSuccessStatusCode)
            {
                var Assurence = response.Content.ReadAsAsync<IEnumerable<Assurence>>().Result;
                return Assurence;
            }
            return new List<Assurence>();


        }



        public Assurence getByIdAssurence(int id)
        {
            Assurence assurence= null;
            var response = httpClient.GetAsync(Statics.baseAddress + "Assurence/getAssuById/" + id).Result;

            if (response.IsSuccessStatusCode)
            {
                var e = response.Content.ReadAsAsync<Assurence>().Result;
                return e;
            }
            return assurence;
        }


        public Boolean ajoutAssurence(Assurence ass)
        {
            try
            {
                var APIResponse = httpClient.PostAsJsonAsync<Assurence>(Statics.baseAddress + "Assurence/ajouterAssu" , ass).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);
                return true;
            }
            catch
            {
                return false;
            }
        }


        public bool deleteAssurence(int idAssu)
        {
            try
            {
                var APIResponse = httpClient.DeleteAsync(Statics.baseAddress + "Assurence/deleteAssu/" + idAssu);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool affecteAssurAbonn(int idAssu , int idAbon)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Assurence>(Statics.baseAddress + "Assurence/affAssAbonn/" + idAssu+"/"+ idAbon,
                 null).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());

                System.Diagnostics.Debug.WriteLine(APIResponse.Result);

                return true;
            }
            catch
            {
                return false;
            }

        }

        //public bool desaffecterAssurenceDuAbon()
        //{

        //}

        public float PrixAssurenceMulti(int idAssu , int idAd  )
        {
            float prixA = 0;

            var response = httpClient.GetAsync(Statics.baseAddress + "Assurence/PrixAssurenceMulti/" + idAssu+"/"+idAd ).Result;

            if (response.IsSuccessStatusCode)
            {
                var prix = response.Content.ReadAsAsync<float>().Result;
                return prix;
            }


            return prixA;
        }


        public bool mettreAjourPrixAssurenceMulti(int idAssu , int idAd )
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Assurence>(Statics.baseAddress + "Assurence/mettreAjourPrixAssuMulti/" + idAssu+"/"+idAd,null).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                System.Diagnostics.Debug.WriteLine(APIResponse.Result);

                return true;
            }
            catch
            {
                return false;
            }
        }


        public float PrixAssurenceMultiLoyerImp( int idAssu , int idAd)
        {

            float prixA = 0;

            var response = httpClient.GetAsync(Statics.baseAddress + "Assurence/PrixAssurenceMultiLoyerImp/" + idAssu + "/" + idAd).Result;

            if (response.IsSuccessStatusCode)
            {
                var prix = response.Content.ReadAsAsync<float>().Result;
                return prix;
            }
            return prixA;
        }



        public bool mettreAjourPrixAssurenceMultiLoyerImp( int idAssu , int idAd)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Assurence>(Statics.baseAddress + "Assurence/mettreAjourPrixAssuloyerImp/" + idAssu + "/" + idAd,null).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
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
