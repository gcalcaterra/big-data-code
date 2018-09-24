namespace php tp1Parcial.schema
namespace java tp1Parcial.schema


#Nodes
union InternetUseId {
	1: string id
}

union IndividualTypeId {
	1: string id
}

union GeographyId {
	1: string id
}


#Edges
struct FactsEdge {
	1: required InternetUseId	internetUse;
	2: required IndividualTypeId	individualType;
	3: required GeographyId		geography;
	4: i32 	year;
	5: i32	units;
}


#Properties
struct ConceptProperties {
	1: required string label;
	2: required string status;
	3: optional i32 modified;
	4: optional string notation;
}

#InternetUse Properties
union InternetUsePropertyValue {
	1: ConceptProperties conceptProperties;
}

struct InternetUseProperty {
	1: required InternetUseId id;
	2: required InternetUsePropertyValue property;
}

#IndividualType Properties
union IndividualTypePropertyValue {
	1: ConceptProperties conceptProperties;
}

struct IndividualTypeProperty {
	1: required IndividualTypeId id;
	2: required IndividualTypePropertyValue property;
}

#Geography Properties
union GeographyPropertyValue {
	1: ConceptProperties conceptProperties;
}

struct GeographyProperty {
	1: required GeographyId id;
	2: required GeographyPropertyValue property;
}

#Tying everything together
union DataUnit {
	1: InternetUseProperty internetUseProperty;
	2: IndividualTypeProperty individualTypeProperty;
	3: GeographyProperty geographyProperty;
	4: FactsEdge factsEdge;
}

struct Pedigree {
	1: required i64 trueAsOfSecs;
}
struct Data {
	1: required Pedigree pedigree;
	2: required DataUnit dataUnit;
} 







