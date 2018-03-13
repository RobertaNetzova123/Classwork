class ComputerInfo < ApplicationRecord
	validates :room_id, uniqueness: true
	validates :processor, uniqueness: true
	belongs_to:room
end
