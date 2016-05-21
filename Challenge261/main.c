#include <stdio.h>

void not_ok(){
	printf("false\n");
}

int main(int argc, char *argv[]){
	if(argc == 1){
		printf("No input file specified with command. Exiting.\n");
		return 1;
	}

	FILE *fp = fopen(argv[1], "r");

	int size;

	fscanf(fp, "%i", &size);

	int grid[size][size];

	int x, y;
	for(y = 0; y < size; y++){
		for(x = 0; x < size; x++){
			fscanf(fp, "%x", &grid[x][y]);
			printf("%i ", grid[x][y]);
		}
		printf("\n");
	}

	int sum;

	for(x = 0; x < size; x++){
        sum = 0;

		for(y = 0; y < size; y++) sum += grid[x][y];

		if(sum != 15){
			not_ok();
			return 0;
		}
	}

	//Check rows
	for(y = 0; y < size; y++){
        sum = 0;

		for(x = 0; x < size; x++) sum += grid[x][y];

		if(sum != 15){
			not_ok();
			return 0;
		}
	}

	//Check major diagonal top-left to bottom-right
	sum = 0;
	for(x = 0, y = 0; x < size; x++, y++){
		sum += grid[x][y];
	}
	if(sum != 15){
		not_ok();
		return 0;
	}


	//Check major diagonal top-left to bottom-right
	sum = 0;
	for(x = 0, y = size-1; x < size; x++, y--){
		sum += grid[x][y];
	}
	if(sum != 15){
		not_ok();
		return 0;
	}

	fclose(fp);

	printf("true\n");
	return 0;
}


