use std::io; 

fn main() {
	let mut input = String::new();
	io::stdin().read_line(&mut input).expect("Failed to get input");
	let people_to_feed : i32 = input.trim().parse().expect("Please type a number");

	let mut input = String::new();
	io::stdin().read_line(&mut input).expect("Failed to get input");
	let fruits_starting : i32 = input.trim().parse().expect("Please type a number");

	let mut week = 1;
	let mut plants = 0;	

	let mut fruits = fruits_starting;
	let mut fruits_last = 0;

	while people_to_feed > fruits {
		plants = fruits + plants;
		fruits = fruits_last + plants;

		week += 1;
		
		fruits_last = fruits;
	}
	
	println!("{}", week);
}
