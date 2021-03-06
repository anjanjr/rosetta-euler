class Array
  def append_until(&block)
    self.each do
      result = block.yield(self)

      self << result if result
    end
  end
end

puts [0, 1].append_until { |s| s[-2] + s[-1] if s[-2] + s[-1] < 4000000 }.select { |n| n.even? }.inject(:+)
