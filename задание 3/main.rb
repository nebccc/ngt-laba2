def init_list
    loop do
      begin
        input = gets
        return [] if input.nil? # Проверяем на nil
        nums = input.chomp.split.map(&:to_i)
        return nums
      rescue ArgumentError
        puts "Error: An invalid value has been entered! Try again: "
      end
    end
  end
  
  
  def is_prime(num)
    return false if num <= 1
  
    (2..Math.sqrt(num).to_i).each do |i|
      return false if num % i == 0
    end
  
    true
  end
  
  def main
    numbers = init_list
  
    prime_count = numbers.count { |num| is_prime(num) }
  
    puts "Number of prime numbers: #{prime_count}"
  end
  
  if __FILE__ == $PROGRAM_NAME
    main
  end