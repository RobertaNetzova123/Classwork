Rails.application.routes.draw do
  resources :rooms
  resources :computer_infos
  get '/B_21_Roberta_Netzovarooms/', to: 'computer_infos#index'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
