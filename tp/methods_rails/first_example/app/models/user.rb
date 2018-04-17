class User < ApplicationRecord
	has_many:user_subscriptions
	has_many:subscriptions,  through: :user_subscriptions
end
