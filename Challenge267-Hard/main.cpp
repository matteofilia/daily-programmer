#include <cstdlib>
#include <iostream>

int main(){
	int width;
	int height;

	short *numHitsRow = new short[height];
	short *numHitsColumn =  new short[width];

	//Lup = left-up diagonal, and so forth
	short *numHitsLown = new short[width+heigth-1];
	short *numHitsLup = new short[width+height-1];

	//Set all values to 0
	int i;
	for(i = 0; i < height; i++){
		*numHitsRow[i] = 0;
	}

	for(i = 0; i < width; i++){
		*numHitsColumn[i] = 0;
	}

	for(i = 0; i < width+height-1; i++){
		*numHitsLown[i] = 0;
		*numHitsLup[i] = 0;
	}

	int x;
	int y;

	//Add possible row hit 
	if(x-1 > -1 && x-1 < columns){
		*numHitsColumns[x-1]++;
	} 

	if(x > -1 && x < columns){
		*numHitsColumns[x]++;
	} 

	if(x+1 > -1 && x+1 < columns){
		*numHitsColumns[x+1]++;
	} 

	//Add possible column hit
	if(y-1 > -1 && y-1 < rows){
		*numHitsRows[y-1]++;
	} 

	if(y > -1 && y < rows){
		*numHitsRows[y]++;
	} 

	if(y+1 > -1 && y+1 < rows){
		*numHitsRows[y+1]++;
	} 

	//Add possible lown hit
	//Add possible lup hit

	int maxHits;
	//Find greatest possible row hits
	//Find grearest possible column hits
	//Find greatest possible lup hits
	//Find greatest possible lown hits

	cout << maxHits << endl;

	return 0;	
}

