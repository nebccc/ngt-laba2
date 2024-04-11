function calculateDrinks(n, m) {
    let totalDrinks = n;
    let iterations = 0;
    let emptyBottles = n;

    let steps = [];

    while (emptyBottles > 1) {
        let newFull = Math.floor(emptyBottles / m);
        if (newFull === 0) {
            break;
        }
        totalDrinks += newFull;
        iterations++;
        emptyBottles = emptyBottles % m + newFull;
        steps.push(`Step ${iterations} - Drank ${newFull} of cans left ${emptyBottles} empty cans`);
    }

    return { totalDrinks, iterations, steps };
}

const n = 15;
const m = 4;

const { totalDrinks, iterations, steps } = calculateDrinks(n, m);
console.log(`Maximum number of cans drunk: ${totalDrinks}`);
console.log(`Number of iterations: ${iterations}`);
steps.forEach(step => console.log(step));
