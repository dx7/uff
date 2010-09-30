class Pilha
  
  @@MAX = 5
  
  def initialize
    @valores = []
    @qtd = 0
  end
  
  def push(valor)
    if @valores.count <= @@MAX
      @valores[@qtd] = valor
      @qtd += 1
    end
  end
  
  def show
    if @qtd == 0
      puts "Vazio"
    else
      (0...@qtd).each do |i|
        print "#{@valores[i]} "
      end
      
      puts ''
    end
  end
  
  def pop
    valor = topo
    @qtd -= 1
    valor
  end
  
  def topo
    @valores[@qtd - 1]
  end
end

def avalia(expressao)
  p = Pilha.new
  
  expressao.each_char do |c|
    if ('0'..'9').include? c
      p.push c.to_i
    else
      c = '**' if c == '$'
      v2 = p.pop
      v1 = p.pop
      
      p.push eval("#{v1} #{c} #{v2}")
    end
  end
  
  puts p.topo
end

avalia("93322$*4/*+")