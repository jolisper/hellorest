require 'sinatra'
require 'sinatra/contrib'
require 'sinatra/json'
require 'gyoku'
require './restdb'

db = RestDB.new

###################

get '/textos/:id' do

  t = db.get( params[:id] )

  if t.nil? 
      error = 404
  else

    respond_with :index do |rformat|
      rformat.txt { t.to_s }
      rformat.json { json( t ) }
      rformat.xml { "<text>"+Gyoku.xml( newOne )+"</text>" }
    end
  end
end

####################

post '/textos' do

  newOne = db.add( params[:texto] )

  print( params[:texto])
  
  if newOne.nil? 
      error = 406
  else

    respond_with :index do |rformat|
      rformat.txt {
        content_type :txt
        newOne.to_s
      }

      rformat.json {
        content_type :json
        json( newOne )
      }

      rformat.xml { Gyoku.xml( newOne ) }
    end
  end
end

###################

put '/textos/:id' do

  t = db.get( params[:id] )

  if t.nil? 
      error = 404
  else

    t = db.set( params[:id], params[:texto] )
    
    respond_with :index do |rformat|
      rformat.txt { t.to_s }
      rformat.json { json( t ) }
      rformat.xml { "<text>"+Gyoku.xml( newOne )+"</text>" }
    end
  end
end

#################

get '/textos' do

  respond_with :index do |rformat|
    rformat.txt { db.to_array.to_s }
    rformat.json { json( db.to_array ) }
    rformat.xml { "<response>" + Gyoku.xml(:text => db.to_array) + "</response>" }
  end
  
end
