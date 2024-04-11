def calculate_drinks(n, m)
  total_drinks = n
  iterations = 0
  empty_bottles = n
  steps = []

  while empty_bottles > 1
      new_full = empty_bottles / m
      break if new_full == 0
      total_drinks += new_full
      iterations += 1
      empty_bottles = empty_bottles % m + new_full
      steps << "Step #{iterations} - Drank #{new_full} of cans left #{empty_bottles} empty cans"
  end

  [total_drinks, iterations, steps]
end

print "Enter the number of full cans: "
n = gets.chomp.to_i

print "Enter the number of empty cans needed for exchange: "
m = gets.chomp.to_i

total_drinks, iterations, steps = calculate_drinks(n, m)
puts "Maximum number of cans drunk: #{total_drinks}"
puts "Number of iterations: #{iterations}"
steps.each { |step| puts step }
