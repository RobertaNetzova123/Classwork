json.extract! computer_info, :id, :color, :brand, :processor, :room_id, :created_at, :updated_at
json.url computer_info_url(computer_info, format: :json)
