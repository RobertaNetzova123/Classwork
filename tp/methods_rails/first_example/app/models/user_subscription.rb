class UserSubscription < ApplicationRecord
	belongs_to :user
	belongs_to :subscription
	validate :price_limits
	
	
		def price_limits
			t = 0
			s = 0
			if self.subscription.price < 10
				self.subscription.user_subscriptions.each do |user_subscription|
					if user_subscription.type_of == "Teacher"
						t += 1
					end
					if user_subscription.type_of == "Student"
						s += 1
					end
					if t >= 2 || s >= 10
					errors.add(self.type_of, "Cannot create another subscription user")
					end
				end
			end
		end

end
