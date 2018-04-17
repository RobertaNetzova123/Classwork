class UserSubscriptionsController < ApplicationController
  before_action :set_user_subscription, only: [:show, :edit, :update, :destroy]

  # GET /user_subscriptions
  # GET /user_subscriptions.json
  def index
    	@user_subscriptions = UserSubscription.all
	@users = User.all
	@subscriptions = Subscription.all
  end

  # GET /user_subscriptions/1
  # GET /user_subscriptions/1.json
  def show
  end

  # GET /user_subscriptions/new
  def new
    @user_subscription = UserSubscription.new
  end

  # GET /user_subscriptions/1/edit
  def edit
  end

  # POST /user_subscriptions
  # POST /user_subscriptions.json
  def create
    @user_subscription = UserSubscription.new(user_subscription_params)

    respond_to do |format|
      if @user_subscription.save
        format.html { redirect_to @user_subscription, notice: 'User subscription was successfully created.' }
        format.json { render :show, status: :created, location: @user_subscription }
      else
        format.html { render :new }
        format.json { render json: @user_subscription.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /user_subscriptions/1
  # PATCH/PUT /user_subscriptions/1.json
  def update
    respond_to do |format|
      if @user_subscription.update(user_subscription_params)
        format.html { redirect_to @user_subscription, notice: 'User subscription was successfully updated.' }
        format.json { render :show, status: :ok, location: @user_subscription }
      else
        format.html { render :edit }
        format.json { render json: @user_subscription.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /user_subscriptions/1
  # DELETE /user_subscriptions/1.json
  def destroy
    @user_subscription.destroy
    respond_to do |format|
      format.html { redirect_to user_subscriptions_url, notice: 'User subscription was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_user_subscription
      @user_subscription = UserSubscription.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def user_subscription_params
      params.require(:user_subscription).permit(:user_id, :subscription_id, :type_of)
    end
end
