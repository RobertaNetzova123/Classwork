class Subject < ApplicationRecord
	validates :teacher_id, uniqueness: true 
	belongs_to :teacher
	
end
