
#simple in memory db
class  RestDB

  def initialize
    @db = {}
  end

  def set(id, txt)
    @db[id] = txt

    get id
  end
  
  def get(id)
    if @db.has_key? id
      {:id => id, :texto => @db[id] }
    else
      nil
    end
  end
  
  def delete(id)
    !@db.delete(id).nil?
  end
  
  def add (txt)
    if txt.nil? || txt.empty?
      nil
    else
      id = Random.new.rand(1000).to_s

      @db[id] = txt

      {:id => id, :texto => txt }
    end
  end
  
  def to_array
    arr = []

    @db.each {|key, value| arr.push({:id=>key, :texto=>value}) }

    arr
  end 

end
