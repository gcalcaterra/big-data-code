package tpBigData.test;


import tpBigData.schema.*;

public class DataProcess {
	
//    public static Pedigree makePedigree(int timeSecs) {
//        return new Pedigree(timeSecs,
//                Source.SELF,
//                OrigSystem.page_view(new PageViewSystem())
//        );
//
//    }
    

	public static Pedigree makePedigree(long timeSecs) {
    	return new Pedigree(timeSecs);
    }

    
    public static Data makeFacts(long timeSecs, String internetUseId, String individualTypeId, String geographyId, int year, int units) {
    	return new Data(makePedigree(timeSecs),
    			DataUnit.factsEdge(
    					new FactsEdge(
								InternetUseId.id(internetUseId),
								IndividualTypeId.id(individualTypeId),
								GeographyId.id(geographyId),
								year,
								units
						)
    				));
	}

//    public static tp1Parcial.schema.Data makePageview(int userid, String url, int timeSecs) {
//        return new tp1Parcial.schema.Data(makePedigree(timeSecs),
//                DataUnit.page_view(
//                        new PageViewEdge(
//                                PersonID.user_id(userid),
//                                PageID.url(url),
//                                1
//                        )));
//    }
//
//    public static tp1Parcial.schema.Data makeEquiv(int user1, int user2) {
//        return new tp1Parcial.schema.Data(makePedigree(1000),
//                DataUnit.equiv(
//                        new EquivEdge(
//                                PersonID.user_id(user1),
//                                PersonID.user_id(user2)
//                        )));
//    }


}
