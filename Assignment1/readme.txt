LotteryGame : 

	1. an array of 5 int for normal numbers and and int for special number
	2. use Random.nextInt() to random generate each normal number, and check all normal numbers had been generate to make sure there's no repeatness (re-generate if any repeat)
	3. random generate specail as the same way above
	4. another array for user's number, use Scanner to get the inputs
	5. sort both array and compare them, count the number that's the same
	6. print out the prizes according to the number
	7. an infinite loop of 4.~6.

NumberPuzzle :
	
	1. random generate an array of number 0~8 (same way as above), 0 represent the blank
	2. count the total amount of each nomber's preceding numbers, no solution for odd
	3. use Scanner to get user's input, if it's 'w' then check if the order is available (blank isn't in the last row), then exchange the blank and the number below it
	4. 'a','s','d' are alike
	5. infinite loop for 3.~4.


Problem Encountered : 
	1. forgot to check for all number while generating them at first
	2. not familiar with java yet